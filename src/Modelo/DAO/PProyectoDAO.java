package Modelo.DAO;

import Modelo.Conexion.ConectarOracle;
import Modelo.Interface.CRUD;
import Modelo.PPartida;
import Modelo.PProyecto;
import static Vistas.V_Login.varCodCiaGlobalDeLogin;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PProyectoDAO implements CRUD<PProyecto>{

    //ConectarOracle conexion=new ConectarOracle();
    ConectarOracle conexion=ConectarOracle.getInstance();
    Connection con;
    Statement ps;
    PreparedStatement pst;
    ResultSet rs;
    CallableStatement myCall;
    
    @Override
    public List listar() {
        List<PProyecto> lista = new ArrayList<>();
        //String sql="SELECT * FROM proyecto order by CODCIA";
        String sql="SELECT CODCIA, CODPYTO, NOMBPYTO, EMPLJEFEPROY, CIACONTRATA, CODCLIENTE, FECREG, ESTPYTO, FECESTADO, VALREFER, costoTotSinIGV, impIGV, COSTOTOTAL, observac, ANNOINI, ANNOFIN, LOGOPROY, VIGENTE "
                 + "FROM PPROYECTO ORDER BY CODCIA";
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                PProyecto pyto = new PProyecto.Builder()
                        .codCia(rs.getInt(1))
                        .codPyto(rs.getInt(2))
                        .nomPyto(rs.getString(3))
                        .emplJefeProy(rs.getInt(4))
                        .ciaContrata(rs.getInt(5))
                        .codCliente(rs.getInt(6))
                        .fecReg(rs.getDate(7))
                        .estPyto(rs.getInt(8))
                        .fecEstado(rs.getDate(9))
                        .valRefer(rs.getDouble(10))
                        .costoTotSinIGV(rs.getDouble(11))
                        .impIGV(rs.getDouble(12))
                        .costoTotal(rs.getDouble(13))
                        .observac(rs.getString(14))
                        .annoIni(rs.getInt(15))
                        .annoFin(rs.getInt(16))
                        .logoProy(rs.getBytes(17))
                        .vigente(rs.getString(18).charAt(0))
                        .build();
                
                lista.add(pyto);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        System.out.println("terminando la lsita");
        System.out.println("abc "+conexion.getValue());
        return lista;
    }

    public int add(PProyecto pyto) {
        System.out.println("{call INSERTAR_PPROYECTO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        try{
           con=conexion.conectar();
           myCall = con.prepareCall("{call INSERTAR_PPROYECTO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
           myCall.setInt(1, pyto.getCodCia());
           myCall.setString(2, pyto.getNomPyto());
           myCall.setInt(3, pyto.getEmplJefeProy());
           myCall.setInt(4, pyto.getCiaContrata());
           myCall.setInt(5, pyto.getCodCliente());
           myCall.setDate(6, pyto.getFecReg());
           myCall.setInt(7, pyto.getEstPyto());
           myCall.setDate(8, pyto.getFecEstado());
           myCall.setDouble(9, pyto.getValRefer());
           myCall.setDouble(10, pyto.getCostoTotSinIGV());
           myCall.setDouble(11, pyto.getImpIGV());
           myCall.setDouble(12, pyto.getCostoTotal());
           myCall.setString(13, pyto.getObservac());
           myCall.setInt(14, pyto.getAnnoIni());
           myCall.setInt(15, pyto.getAnnoFin());
           myCall.setBytes(16, pyto.getLogoProy());
           myCall.setString(17, String.valueOf(pyto.getVigente()));
           myCall.execute();
           myCall.close();
           con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+ex.toString());
            System.out.println(ex.toString());
            return 0;
        }
       return 1;
    }

    public int actualizar(PProyecto pyto) {
        String sql1= "update PPROYECTO set CODCIA=?,NOMBPYTO=?,EMPLJEFEPROY=?,CIACONTRATA=?,CODCLIENTE=?,FECREG=?,ESTPYTO=?,FECESTADO=?,VALREFER=?,COSTOTOTSINIGV=?,IMPIGV=?,COSTOTOTAL=?,OBSERVAC=?,ANNOINI=?,ANNOFIN=?,LOGOPROY=?,VIGENTE=? where CODPYTO=?";
        System.out.println(sql1);
        try{
           con=conexion.conectar();
           pst=con.prepareStatement(sql1);
           pst.setInt(1, pyto.getCodCia());
           pst.setString(2, pyto.getNomPyto());
           pst.setInt(3, pyto.getEmplJefeProy());
           pst.setInt(4, pyto.getCiaContrata());
           pst.setInt(5, pyto.getCodCliente());
           pst.setDate(6, pyto.getFecReg());
           pst.setInt(7, pyto.getEstPyto());
           pst.setDate(8, pyto.getFecEstado());
           pst.setDouble(9, pyto.getValRefer());
           pst.setDouble(10, pyto.getCostoTotSinIGV());
           pst.setDouble(11, pyto.getImpIGV());
           pst.setDouble(12, pyto.getCostoTotal());
           pst.setString(13, pyto.getObservac());
           pst.setInt(14, pyto.getAnnoIni());
           pst.setInt(15, pyto.getAnnoFin());
           pst.setBytes(16, pyto.getLogoProy());
           pst.setString(17, String.valueOf(pyto.getVigente()));
           pst.setInt(18, pyto.getCodPyto());
           pst.execute();
           pst.close();
           con.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+ex.toString());
            System.out.println(ex.toString());
            return 0;
        }
        return 1;
    }

    @Override
    public void eliminar(int id) {
        String sql1="DELETE from PPROYECTO where CODPYTO="+id;
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql1);
            rs=ps.executeQuery(sql1);
            rs.close();
            ps.close();
            con.close();
            JOptionPane.showMessageDialog(null, "PProyecto eliminado con exito.");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
    }
    
    //Metodos Adicionales
    public PProyecto listarId(int id){
        PProyecto pyto = new PProyecto.Builder().build();
        //String sql="SELECT * FROM PROYECTO WHERE CODPYTO="+id;
        String sql="SELECT CODCIA, CODPYTO, NOMBPYTO, EMPLJEFEPROY, CIACONTRATA, CODCLIENTE, FECREG, ESTPYTO, FECESTADO, VALREFER, costoTotSinIGV, impIGV, COSTOTOTAL, observac, ANNOINI, ANNOFIN, LOGOPROY, VIGENTE "
                 + "FROM PPROYECTO WHERE CODPYTO="+id+" ORDER BY CODPYTO";
        try{
            con = conexion.conectar();
            ps=con.createStatement();
            rs = ps.executeQuery(sql);
            if(rs.next()){
                pyto = new PProyecto.Builder()
                        .codCia(rs.getInt(1))
                        .codPyto(rs.getInt(2))
                        .nomPyto(rs.getString(3))
                        .emplJefeProy(rs.getInt(4))
                        .ciaContrata(rs.getInt(5))
                        .codCliente(rs.getInt(6))
                        .fecReg(rs.getDate(7))
                        .estPyto(rs.getInt(8))
                        .fecEstado(rs.getDate(9))
                        .valRefer(rs.getDouble(10))
                        .costoTotSinIGV(rs.getDouble(11))
                        .impIGV(rs.getDouble(12))
                        .costoTotal(rs.getDouble(13))
                        .observac(rs.getString(14))
                        .annoIni(rs.getInt(15))
                        .annoFin(rs.getInt(16))
                        .logoProy(rs.getBytes(17))
                        .vigente(rs.getString(18).charAt(0))
                        .build();
            }
            rs.close();
            ps.close();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Excepcion.\n"+e.toString());
            System.out.println(e.toString());
        }
        System.out.println("abc "+conexion.getValue());
        return pyto;
    }    
    
    public List listarPorCodCia(int id) {
        List<PProyecto> lista = new ArrayList<>();
        //String sql="SELECT * FROM proyecto  WHERE CODCIA="+id+" order by CODCIA";
        String sql="SELECT CODCIA, CODPYTO, NOMBPYTO, EMPLJEFEPROY, CIACONTRATA, CODCLIENTE, FECREG, ESTPYTO, FECESTADO, VALREFER, costoTotSinIGV, impIGV, COSTOTOTAL, observac, ANNOINI, ANNOFIN, LOGOPROY, VIGENTE "
                 + "FROM PPROYECTO WHERE CODCIA="+id+" ORDER BY CODCIA";
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                PProyecto pyto = new PProyecto.Builder()
                        .codCia(rs.getInt(1))
                        .codPyto(rs.getInt(2))
                        .nomPyto(rs.getString(3))
                        .emplJefeProy(rs.getInt(4))
                        .ciaContrata(rs.getInt(5))
                        .codCliente(rs.getInt(6))
                        .fecReg(rs.getDate(7))
                        .estPyto(rs.getInt(8))
                        .fecEstado(rs.getDate(9))
                        .valRefer(rs.getDouble(10))
                        .costoTotSinIGV(rs.getDouble(11))
                        .impIGV(rs.getDouble(12))
                        .costoTotal(rs.getDouble(13))
                        .observac(rs.getString(14))
                        .annoIni(rs.getInt(15))
                        .annoFin(rs.getInt(16))
                        .logoProy(rs.getBytes(17))
                        .vigente(rs.getString(18).charAt(0))
                        .build();  
                lista.add(pyto);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        System.out.println("terminando la lista");
        System.out.println(conexion.getValue());
        return lista;
    }
    
    //Me parece que estuvo mal, ya esta fixeado.
    public List listarPorCodCliente(int id) {
        List<PProyecto> lista = new ArrayList<>();
        String sql="SELECT CODCIA, CODPYTO, NOMBPYTO, EMPLJEFEPROY, CIACONTRATA, CODCLIENTE, FECREG, ESTPYTO, FECESTADO, VALREFER, costoTotSinIGV, impIGV, COSTOTOTAL, observac, ANNOINI, ANNOFIN, LOGOPROY, VIGENTE "
                 + "FROM PPROYECTO WHERE CODCIA="+varCodCiaGlobalDeLogin+" AND CODCLIENTE="+id+" ORDER BY CODCLIENTE";
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                PProyecto pyto = new PProyecto.Builder()
                        .codCia(rs.getInt(1))
                        .codPyto(rs.getInt(2))
                        .nomPyto(rs.getString(3))
                        .emplJefeProy(rs.getInt(4))
                        .ciaContrata(rs.getInt(5))
                        .codCliente(rs.getInt(6))
                        .fecReg(rs.getDate(7))
                        .estPyto(rs.getInt(8))
                        .fecEstado(rs.getDate(9))
                        .valRefer(rs.getDouble(10))
                        .costoTotSinIGV(rs.getDouble(11))
                        .impIGV(rs.getDouble(12))
                        .costoTotal(rs.getDouble(13))
                        .observac(rs.getString(14))
                        .annoIni(rs.getInt(15))
                        .annoFin(rs.getInt(16))
                        .logoProy(rs.getBytes(17))
                        .vigente(rs.getString(18).charAt(0))
                        .build();
                
                lista.add(pyto);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        System.out.println(conexion.getValue());
        return lista;
    }
    
    public String retornarNombrePyto(int codcia, int codpyto){
        String name="";
        
        String sql="SELECT NOMBPYTO FROM PPROYECTO WHERE CODCIA="+codcia+" AND CODPYTO="+codpyto;
        try{
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                name=rs.getString(1);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return name;
    }

    @Override
    public int add(PPartida t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int actualizar(PPartida t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
