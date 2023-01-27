package com.signcorporation.milesa.model.DAO;

import BD.ConexaoBD;
import MODELO.BEAN.Venda;
import MODELO.BEAN.Venda.ItemVenda;
import MODELO.UTILS.Situacao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Hacker PC
 */
public class VendaDAO {
    public static void salvar(Venda venda) throws Exception {
        if (venda.getCodVenda() == 0) {
            inserir(venda);
        } else {
            alterar(venda);
        }
    }

    public static void inserir(Venda venda) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = "INSERT INTO FATURAS (CODIGOCLIENTE, DATAVENDA, VALORTOTAL, SITUACAO) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        if (venda.getCodCliente() == null) {
            ps.setNull(1, java.sql.Types.INTEGER);
            ps.setNull(2, java.sql.Types.INTEGER);
            ps.setString(7, "CONSUMIDOR FINAL");
        } else {
            if (venda.getCodCliente().getPessoaFisica().equals("PessoaFisica"))
                ps.setInt(1, venda.getCodCliente().getPessoaFisica().getCodPessoaFisica());
            else
                ps.setNull(1, java.sql.Types.INTEGER);
            if (venda.getCodCliente().getPessoaJuridica().equals("PessoaJuridica"))
                ps.setInt(2, venda.getCodCliente().getPessoaJuridica().getCodPessoaJuridica());
            else
                ps.setNull(2, java.sql.Types.INTEGER);


        }
        ps.setInt(1, venda.getCodCliente().getCodPessoa());
        ps.setDate(2, new Date(venda.getDataVenda().getTime()));
        ps.setDouble(3, venda.getValorTotal());
        ps.setInt(4, venda.getSituacao().getId());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int idVenda = rs.getInt(1);

        for (Venda.ItemVenda iv : venda.getItens()) {
            sql = "INSERT INTO FATURA_ITENS (COD_PRODUTO, QTD, PVP, FATURA_ID,DOC_NUMERO,DOC_TIPO_ID,"
                    + "DOC_SERIE,ARMAZEM_ID,DESCRICAO,UN,NR_LOTE,"
                    + "COR,DESCONTO,DEB_CRED,FOB,CIF,TAXA_CONV, LANCADO,OBS,PVP_MANUAL,MOV_STK,IPC_PROCESSADO,ARTG_ENCARGOS,ARTG_ENCARGOS_PROCESSADOS,"
                    + "ARTG_ENCARGOS_TOTAL,PCM_PROCESSADO,VEICULO_ID,VEICULO_OBS,TOTAL_ITEM,TOTAL_ITEM_DESCONTO,TOTAL_PAGO_ITEM,DOC_ORIGEM_ITEM"
                    + "CURSO_INSCRICAO_ID,,ENCARGOS_DOC_ID,ENCARGOS_FOB,SERVICO_RETENCAO,SERVICO_RETENCAO_PORC,SERVICO_RETENCAO_VLR"
                    + "ENCARGOS_CO_EFICIENTE,PCM0,PCU0,PVP0,P_UN,TIPO_PROD_ID,DATA_MOV,DATA_INSERCAO,DATA_ULT_MODIFICACAO,TIPO_MOV_STK) VALUES (?, ?, ?, ?)";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, iv.getProduto().getCODPRODUTO());
            ps.setInt(2, idVenda);
            ps.setInt(3, iv.getQuantidade());
            ps.setDouble(4, iv.getValorUnitario());
            ps.execute();

//TIPO_MOV_STK int(11) 
//FINANCEIRO_TIPO_ID int(11) 
//QUNT_FORMULA int(11) 
//STOCK_ATUAL int(11) 
//ARTIGO_SUJEITO_ENCARGO tinyint(4) 
//UNIDADE_BASE_ID int(11) 
//UNIDADE_MOV_ID int(11) 
//LINHA_NR int(11) 
//NIVEL_LINHA int(11) 
//VENDEDOR_ID int(11) 
//DATA_ENTREGA datetime 
//DATA_PRODUCAO datetime 
//DATA_VALIDADE datetime 
//QTD_CAIXA int(11) 
//CAIXA_ID int(11) 
//PART_NUMBER varchar(45) 
//STK_ATUALIZADO tinyint(4) 
//QTD_ORIGINAL varchar(45) 
//TIPO_UN_MEDIDA int(11) 
//STK_INICIAL tinyint(4) 
//IMPRIMIR_EM_DOC tinyint(4) 
//IMPRIMIR_EM_CONSULTA tinyint(4) 
//INPRIMIR_EM_CONSULTA tinyint(4) 
//ARTIGO_PAI_ID int(11) 
//HORA_INICIO datetime 
//HORA_FIM datetime 
//DESCONTO_FINANCEIRO_LINHA int(11) 
//CATEGORIA_ID int(11) 
//DOC_ANULADO tinyint(4) 
//IPC decimal(10,0) 
//VLR_IPC decimal(10,0) 
//ID_ORIGINAL int(11) 
//ID_REG_EXPORTADO decimal(10,0) 
//IVA decimal(10,0) 
//IVA_VLR decimal(10,0) 
//IVA_ID
            if (venda.getSituacao() == Situacao.FINALIZADA) {
                ProdutoEstoqueDAO.saidaEstoque(conexao, iv.getProduto().getCODPRODUTO(), iv.getQuantidade());
            }
        }
        c.confirmar();
    }

    public static void alterar(Venda venda) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();

        String sql = "UPDATE TBVENDA SET CODIGOCLIENTE=?, DATAVENDA=?, VALORTOTAL=?, SITUACAO=? WHERE CODIGO=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, venda.getCodCliente().getCodPessoa());
        ps.setDate(2, new Date(venda.getDataVenda().getTime()));
        ps.setDouble(3, venda.getValorTotal());
        ps.setInt(4, venda.getSituacao().getId());
        ps.setInt(5, venda.getCodVenda());
        ps.execute();

        for (Venda.ItemVenda iv : venda.getItensRemover()) {
            sql = "DELETE FROM TBITEMVENDA WHERE CODIGO=?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, iv.getCodigo());
            ps.execute();
        }

        for (Venda.ItemVenda iv : venda.getItens()) {
            if (iv.getCodigo() == 0) {
                sql = "INSERT INTO TBITEMVENDA (CODIGOPRODUTO, CODIGOVENDA, QUANTIDADE, VALORUNITARIO) VALUES (?, ?, ?, ?)";
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, iv.getProduto().getCODPRODUTO());
                ps.setInt(2, venda.getCodVenda());
                ps.setInt(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.execute();
            } else {
                sql = "UPDATE TBITEMVENDA SET CODIGOPRODUTO=?, CODIGOVENDA=?, QUANTIDADE=?, VALORUNITARIO=? WHERE CODIGO=?";
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, iv.getProduto().getCODPRODUTO());
                ps.setInt(2, venda.getCodVenda());
                ps.setInt(3, iv.getQuantidade());
                ps.setDouble(4, iv.getValorUnitario());
                ps.setInt(5, iv.getCodigo());
                ps.execute();
            }

            if (venda.getSituacao() == Situacao.FINALIZADA) {
                ProdutoEstoqueDAO.saidaEstoque(conexao, iv.getProduto().getCODPRODUTO(), iv.getQuantidade());
            }
        }

        c.confirmar();
    }

    public static void excluir(Venda venda) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();

        String sql = "UPDATE FATURA SET CODIGOCLIENTE=?, DATAVENDA=?, VALORTOTAL=?, STATUS=? WHERE CODVENDA=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, venda.getCodCliente().getCodPessoa());
        ps.setDate(2, new Date(venda.getDataVenda().getTime()));
        ps.setDouble(3, venda.getValorTotal());
        ps.setInt(4, Situacao.CANCELADA.getId());
        ps.setInt(5, venda.getCodVenda());
        ps.execute();
        c.confirmar();
    }

    public static int quantidade(String filtro) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = ""
                + " SELECT COUNT(1) "
                + " FROM FATURAS AS V"
                + " INNER JOIN CLIENTE AS C "
                + " ON C.CODPESSOA = V.CODIGOCLIENTE "
                + " WHERE C.NOME LIKE ? ";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return 0;
    }

    public static ObservableList<Venda> listar(String filtro, int quantidade, int pagina) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        String sql = ""
                + " SELECT V.* "
                + " FROM FATURA AS V"
                + " INNER JOIN CLIENTE AS C "
                + " ON C.CODPESSOA = V.CODIGOCLIENTE "
                + " WHERE C.NOME LIKE ? "
                + " ORDER BY V.SITUACAO ASC, V.DATAVENDA DESC "
                + " LIMIT ?,? ";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, "%" + filtro + "%");
        ps.setInt(2, pagina * quantidade);
        ps.setInt(3, quantidade);
        ResultSet rs = ps.executeQuery();

        ObservableList listaVendas = FXCollections.observableArrayList();
        while (rs.next()) {
            Venda venda = new Venda();
            venda.setCodVenda(rs.getInt("CODIGO"));
//            venda.setCliente(ClienteDAO.recuperar(rs.getInt("CODIGOCLIENTE")));
            venda.setDataVenda(rs.getDate("DATAVENDA"));
            venda.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM TBITEMVENDA WHERE CODIGOVENDA=?";
            PreparedStatement psItem = conexao.prepareStatement(sqlItem);
            psItem.setInt(1, venda.getCodVenda());
            ResultSet rsItem = psItem.executeQuery();

            while (rsItem.next()) {
                Venda.ItemVenda iv = venda.new ItemVenda();
                iv.setCodigo(rsItem.getInt("CODIGO"));
                iv.setProduto(ProdutoDAO.get(rsItem.getInt("CODIGOPRODUTO")));
                iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
                iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
                venda.addItem(iv);
            }

            listaVendas.add(venda);
        }

        return listaVendas;
    }

    public static Venda recuperar(int codigo) throws Exception {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();

        String sql = "SELECT * FROM TBVENDA WHERE CODIGO=?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Venda venda = new Venda();
        if (rs.next()) {
            venda.setCodVenda(rs.getInt("CODIGO"));
//            venda.setCliente(ClienteDAO.(rs.getInt("CODIGOCLIENTE")));
            venda.setDataVenda(rs.getDate("DATAVENDA"));
            venda.setSituacao(rs.getInt("SITUACAO"));

            String sqlItem = "SELECT * FROM TBITEMVENDA WHERE CODIGOVENDA=?";
            PreparedStatement psItem = conexao.prepareStatement(sqlItem);
            psItem.setInt(1, venda.getCodVenda());
            ResultSet rsItem = psItem.executeQuery();

            while (rsItem.next()) {
                Venda.ItemVenda iv = venda.new ItemVenda();
                iv.setCodigo(rsItem.getInt("CODIGO"));
                iv.setProduto(ProdutoDAO.get(rsItem.getInt("CODIGOPRODUTO")));
                iv.setQuantidade(rsItem.getInt("QUANTIDADE"));
                iv.setValorUnitario(rsItem.getDouble("VALORUNITARIO"));
                venda.addItem(iv);
            }
        }

        return venda;
    }

    private void tipo_documento(int indice, String legenda) {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        try {
            Statement st = conexao.createStatement();
            String SQL = null;

            if (indice == 13) {

            }
        } catch (Exception e) {
        }

    }

    private void tipo_fatura(String legenda, int indice) {
        ConexaoBD c = new ConexaoBD();
        Connection conexao = c.getInstance().getConnection();
        try {
            Statement st = conexao.createStatement();
            String SQL = null;

            if (indice == 13) {

            }
        } catch (Exception e) {
        }

    }

}

















