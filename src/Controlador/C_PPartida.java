package Controlador;

import Modelo.DAO.ElementosDAO;
import Modelo.DAO.PPartidaDAO;
import Modelo.DAO.TabsDAO;
import Modelo.Elementos;
import Modelo.Message.Mensaje1;
import Modelo.Message.Mensaje2;
import Modelo.PPartida;
import Modelo.Tabs;
import static Vistas.V_Login.varCodCiaGlobalDeLogin;
import Vistas.V_PPartida;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

import Custom_by_me.SelectElements;
import Custom_by_me.SelectTabs;

public class C_PPartida implements ItemListener, ActionListener, KeyListener, MouseListener {

    PPartidaDAO pDAO = new PPartidaDAO();
    V_PPartida vp = new V_PPartida();
    DefaultTableModel modelPartidaI = new DefaultTableModel();
    DefaultTableModel modelPartidaE = new DefaultTableModel();
    TableRowSorter<DefaultTableModel> sorterI;
    TableRowSorter<DefaultTableModel> sorterE;
    int id = -1;

    /*Para qué*/
    List<Elementos> elementos;
    List<Tabs> tabs;

    public C_PPartida(V_PPartida vp) {
        this.vp = vp;
        this.vp.btt_Actualizar_I.addActionListener(this);
        this.vp.btt_Registrar_I.addActionListener(this);
        this.vp.btt_Eliminar_I.addActionListener(this);
        this.vp.tablaPartida_I.addMouseListener(this);
        this.vp.tUniMed_I.addItemListener(this);
        this.vp.btt_Actualizar_E.addActionListener(this);
        this.vp.btt_Registrar_E.addActionListener(this);
        this.vp.btt_Eliminar_E.addActionListener(this);
        this.vp.tablaPartida_E.addMouseListener(this);
        this.vp.tUniMed_E.addItemListener(this);
        this.vp.actualizaTabla.addActionListener(this);
        this.vp.nuevo.addActionListener(this);
        this.elementos = new ElementosDAO().listar();
        this.tabs = new TabsDAO().listar();
        init();
    }

    public void init() {
        initTablaPartida_I();
        initTablaPartida_E();
        vp.init();
        initListarTabs();
        ((AbstractDocument) vp.desPartida_I.getDocument()).setDocumentFilter(new LimitDocumentFilter(30, 0));
        ((AbstractDocument) vp.desPartida_E.getDocument()).setDocumentFilter(new LimitDocumentFilter(30, 0));
    }

    public void initListarTabs() {
        System.out.println("Tabs");
        vp.tUniMed_I.removeAllItems();
        vp.tUniMed_E.removeAllItems();
        List<Tabs> listaTab = new TabsDAO().listar();
        for (int i = 0; i < listaTab.size(); i++) {
            String descripcion = listaTab.get(i).getDenTab();
            String codigo = listaTab.get(i).getCodTab();
            vp.tUniMed_I.addItem(new SelectTabs(descripcion, codigo));
            vp.tUniMed_E.addItem(new SelectTabs(descripcion, codigo));

            // vp.tUniMed_I.addItem("test");
            // vp.tUniMed_E.addItem("test");
        }
    }

    public void initListarElementos_I(int cod) {
        //System.out.println("Elementos");
        vp.eUniMed_I.removeAllItems();
        List<Elementos> listaEle = new ElementosDAO().listarTabs(cod);
        for (int i = 0; i < listaEle.size(); i++) {
            String descripcion = listaEle.get(i).getDenElemento();
            String codigo = listaEle.get(i).getCodElemento();
            vp.eUniMed_I.addItem(new SelectElements(descripcion, codigo));
            // vp.eUniMed_I.addItem(listaEle.get(i).getCodElemento());
        }
    }

    public void initListarElementos_E(int cod) {
        vp.eUniMed_E.removeAllItems();
        List<Elementos> listaEle = new ElementosDAO().listarTabs(cod);
        for (int i = 0; i < listaEle.size(); i++) {
            String descripcion = listaEle.get(i).getDenElemento();
            String codigo = listaEle.get(i).getCodElemento();
            vp.eUniMed_E.addItem(new SelectElements(descripcion, codigo));
            // vp.eUniMed_E.addItem(listaEle.get(i).getCodElemento());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("DENTRO DE ACTION PARTIDA");
        if (e.getSource() == vp.btt_Registrar_I) {
            registrarDatos("I");
            actualizarTabla();
        }
        if (e.getSource() == vp.btt_Actualizar_I) {
            actualizarDatos("I");
            actualizarTabla();
        }
        if (e.getSource() == vp.btt_Eliminar_I) {
            eliminarDatos("I");
            actualizarTabla();
        }
        if (e.getSource() == vp.btt_Registrar_E) {
            registrarDatos("E");
            actualizarTabla();
        }
        if (e.getSource() == vp.btt_Actualizar_E) {
            actualizarDatos("E");
            actualizarTabla();
        }
        if (e.getSource() == vp.btt_Eliminar_E) {
            eliminarDatos("E");
            actualizarTabla();
        }
        if (e.getSource() == vp.actualizaTabla) {
            actualizarTabla();
        }
        if (e.getSource() == vp.nuevo) {
            vaciarCampos();
            actualizarTabla();
        }
    }

    public void actualizarTabla() {
        limpiarTabla(modelPartidaI);
        limpiarTabla(modelPartidaE);
        initTablaPartida_I();
        initTablaPartida_E();
        //System.out.println("Refrescando tabla automaticamente.");
    }

    public void initTablaPartida_I() {

        List<PPartida> listaI = pDAO.listarPorCodCia(varCodCiaGlobalDeLogin, "I");
        modelPartidaI = (DefaultTableModel) vp.tablaPartida_I.getModel();
        Object[] o = new Object[6];
        sorterI = new TableRowSorter<>(modelPartidaI);
        vp.tablaPartida_I.setRowSorter(sorterI);
        limpiarTabla(modelPartidaI);
        for (int i = 0; i < listaI.size(); i++) {
            o[0] = listaI.get(i).getCodPartida();
            o[1] = listaI.get(i).getCodPartidas();
            o[2] = listaI.get(i).getDesPartida();

            String tabID = (listaI.get(i).gettUniMed());
            this.tabs.forEach((tab) -> {
                if (tab.getCodTab().equals(tabID)) {
                    Object item1 = new SelectTabs(tab.getDenTab(), tab.getCodTab());
                    o[3] = item1;
                }
            });
            // o[3] = listaE.get(i).gettUniMed();

            String elementoID = (listaI.get(i).geteUniMed());
            this.elementos.forEach((elemento) -> {

                if (elemento.getCodElemento().equals(elementoID) && elemento.getCodTab().equals(tabID)) {
                    Object item2 = new SelectElements(elemento.getDenElemento(), elemento.getCodElemento());
                    o[4] = item2;
                }
            });
            // o[4] = listaE.get(i).geteUniMed();

            o[5] = (listaI.get(i).getVigente()) == '1' ? "Si" : "No";
            modelPartidaI.addRow(o);
        }
        vp.tablaPartida_I.setModel(modelPartidaI);
    }

    public void initTablaPartida_E() {
        List<PPartida> listaE = pDAO.listarPorCodCia(varCodCiaGlobalDeLogin, "E");
        modelPartidaE = (DefaultTableModel) vp.tablaPartida_E.getModel();
        Object[] o = new Object[6];
        sorterE = new TableRowSorter<>(modelPartidaE);
        vp.tablaPartida_E.setRowSorter(sorterE);
        limpiarTabla(modelPartidaE);
        for (int i = 0; i < listaE.size(); i++) {
            o[0] = listaE.get(i).getCodPartida();
            o[1] = listaE.get(i).getCodPartidas();
            o[2] = listaE.get(i).getDesPartida();

            String tabID = (listaE.get(i).gettUniMed());
            this.tabs.forEach((tab) -> {
                if (tab.getCodTab().equals(tabID)) {
                    Object item1 = new SelectTabs(tab.getDenTab(), tab.getCodTab());
                    o[3] = item1;
                }
            });
            // o[3] = listaE.get(i).gettUniMed();

            String elementoID = (listaE.get(i).geteUniMed());
            this.elementos.forEach((elemento) -> {

                if (elemento.getCodElemento().equals(elementoID) && elemento.getCodTab().equals(tabID)) {
                    Object item2 = new SelectElements(elemento.getDenElemento(), elemento.getCodElemento());
                    o[4] = item2;
                }
            });
            // o[4] = listaE.get(i).geteUniMed();

            o[5] = (listaE.get(i).getVigente()) == '1' ? "Si" : "No";
            modelPartidaE.addRow(o);
        }
        vp.tablaPartida_E.setModel(modelPartidaE);
    }

    public void limpiarTabla(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        return;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila, cod;
        if (e.getSource() == vp.tablaPartida_I) {
            fila = vp.tablaPartida_I.getSelectedRow();
            cod = Integer.parseInt(vp.tablaPartida_I.getValueAt(fila, 0).toString());
            PPartida pI = new PPartidaDAO().listarId(varCodCiaGlobalDeLogin, cod, "I");
            vp.desPartida_I.setText(pI.getDesPartida());

            String tabID = (pI.gettUniMed());
            this.tabs.forEach((tab) -> {
                if (tab.getCodTab().equals((tabID))) {
                    Object item = new SelectTabs(tab.getDenTab(), tab.getCodTab());
                    vp.tUniMed_I.setSelectedItem(item);
                }
            });

            String ElementoID = (pI.geteUniMed());
            this.elementos.forEach((elemento) -> {
                if (elemento.getCodElemento().equals(ElementoID) && elemento.getCodTab().equals(tabID)) {
                    Object item2 = new SelectElements(elemento.getDenElemento(), elemento.getCodElemento());
                    vp.eUniMed_I.setSelectedItem(item2);
                }
            });
            // vp.tUniMed_I.setSelectedItem(pI.gettUniMed());
            // vp.eUniMed_I.setSelectedItem(pI.geteUniMed());
            vp.vigente_I.setSelectedItem((pI.getVigente() == '1' ? "Vigente" : "No Vigente"));
        }

        if (e.getSource() == vp.tablaPartida_E) {
            fila = vp.tablaPartida_E.getSelectedRow();
            cod = Integer.parseInt(vp.tablaPartida_E.getValueAt(fila, 0).toString());
            //System.out.println("PartidaMezcla = " + cod);
            PPartida pE = new PPartidaDAO().listarId(varCodCiaGlobalDeLogin, cod, "E");
            vp.desPartida_E.setText(pE.getDesPartida());

            String tabID = (pE.gettUniMed());
            this.tabs.forEach((tab) -> {
                if (tab.getCodTab().equals((tabID))) {
                    Object item = new SelectTabs(tab.getDenTab(), tab.getCodTab());
                    vp.tUniMed_E.setSelectedItem(item);
                }
            });

            String ElementoID = (pE.geteUniMed());
            this.elementos.forEach((elemento) -> {
                if (elemento.getCodElemento().equals(ElementoID) && elemento.getCodTab().equals(tabID)) {
                    Object item2 = new SelectElements(elemento.getDenElemento(), elemento.getCodElemento());
                    vp.eUniMed_E.setSelectedItem(item2);
                }
            });
            // vp.tUniMed_E.setSelectedItem(pE.gettUniMed());
            // vp.eUniMed_E.setSelectedItem(pE.geteUniMed());
            vp.vigente_E.setSelectedItem((pE.getVigente() == '1' ? "Vigente" : "No Vigente"));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        return;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }

    public void registrarDatos(String tip) {
        PPartida pm = new PPartida();
        char vig;
        if (tip == "I") {
            pm.setCodCia(varCodCiaGlobalDeLogin);
            pm.setIngEgr(tip);

            Object item = vp.tUniMed_I.getSelectedItem();
            String value = ((SelectTabs) item).getValue();
            pm.settUniMed(value);
            // pm.settUniMed(vp.tUniMed_I.getSelectedItem().toString());

            Object item2 = vp.eUniMed_I.getSelectedItem();
            String value2 = ((SelectElements) item2).getValue();
            pm.seteUniMed(value2);
            // pm.seteUniMed(vp.eUniMed_I.getSelectedItem().toString());

            pm.setDesPartida(vp.desPartida_I.getText());
            vig = "Vigente".equals(vp.vigente_I.getSelectedItem().toString()) ? '1' : '0';
            pm.setVigente(vig);
        } else {
            pm.setCodCia(varCodCiaGlobalDeLogin);
            pm.setIngEgr(tip);

            Object item = vp.tUniMed_E.getSelectedItem();
            String value = ((SelectTabs) item).getValue();
            pm.settUniMed(value);
            // pm.settUniMed(vp.tUniMed_E.getSelectedItem().toString());

            Object item2 = vp.eUniMed_E.getSelectedItem();
            String value2 = ((SelectElements) item2).getValue();
            pm.seteUniMed(value2);
            // pm.seteUniMed(vp.eUniMed_E.getSelectedItem().toString());
            pm.setDesPartida(vp.desPartida_E.getText());
            vig = "Vigente".equals(vp.vigente_E.getSelectedItem().toString()) ? '1' : '0';
            pm.setVigente(vig);
        }
        if (pDAO.add(pm) == 1) { // Corregir
            showMessage2("Partida registrada correctamente");
            vaciarCampos();
        } else {
            showMessage1("Error al registrar Partida");
        }
    }

    private boolean showMessage1(String message) {
        Mensaje1 obj = new Mensaje1(Frame.getFrames()[1], true);
        obj.showMessage(message);
        return obj.isAceptar();
    }

    private boolean showMessage2(String message) {
        Mensaje2 obj = new Mensaje2(Frame.getFrames()[1], true);
        obj.showMessage(message);
        return obj.isAceptar();
    }

    public void actualizarDatos(String tip) {
        int fila, cod;
        char vig;
        PPartida pm = new PPartida();
        if (tip == "I") {
            fila = vp.tablaPartida_I.getSelectedRow();
            if (fila != -1) {
                cod = Integer.parseInt(vp.tablaPartida_I.getValueAt(fila, 0).toString());
                pm.setCodCia(varCodCiaGlobalDeLogin);
                pm.setIngEgr(tip);
                pm.setCodPartida(cod);
                pm.setDesPartida(vp.desPartida_I.getText());

                Object item = vp.tUniMed_I.getSelectedItem();
                String value = ((SelectTabs) item).getValue();
                pm.settUniMed(value);

                Object item2 = vp.eUniMed_I.getSelectedItem();
                String value2 = ((SelectElements) item2).getValue();
                pm.seteUniMed(value2);
                // pm.seteUniMed(vp.eUniMed_I.getSelectedItem().toString());

                vig = "Vigente".equals(vp.vigente_I.getSelectedItem().toString()) ? '1' : '0';
                pm.setVigente(vig);
                if (pDAO.actualizar(pm) == 1) {
                    showMessage2("Partida registrado correctamente");
                    vaciarCampos();
                } else {
                    showMessage1("Error al registrar Partida");
                }
            } else {
                showMessage1("Debe seleccionar una fila");
            }
        } else {
            fila = vp.tablaPartida_E.getSelectedRow();
            if (fila != -1) {
                //System.out.println("Hay filas seleccionadas.");
                cod = Integer.parseInt(vp.tablaPartida_E.getValueAt(fila, 0).toString());
                pm.setCodCia(varCodCiaGlobalDeLogin);
                pm.setIngEgr(tip);
                pm.setCodPartida(cod);
                pm.setDesPartida(vp.desPartida_E.getText());

                Object item = vp.tUniMed_E.getSelectedItem();
                String value = ((SelectTabs) item).getValue();
                pm.settUniMed(value);
                // pm.settUniMed(vp.tUniMed_E.getSelectedItem().toString());

                Object item2 = vp.eUniMed_E.getSelectedItem();
                String value2 = ((SelectElements) item2).getValue();
                pm.seteUniMed(value2);
                // pm.seteUniMed(vp.eUniMed_E.getSelectedItem().toString());

                vig = "Vigente".equals(vp.vigente_E.getSelectedItem().toString()) ? '1' : '0';
                pm.setVigente(vig);
                if (pDAO.actualizar(pm) == 1) {
                    showMessage2("Partida registrado correctamente");
                    vaciarCampos();
                } else {
                    showMessage1("Error al registrar Partida");
                }
            } else {
                showMessage1("Debe seleccionar una fila");
            }
        }
    }

    public void eliminarDatos(String tip) {
        int fila, cod;
        if (tip == "I") {
            fila = vp.tablaPartida_I.getSelectedRow();
            //System.out.println("La fila es" + fila);
            if (fila != -1) {
                //System.out.println("Hay filas seleccionadas.");
                cod = Integer.parseInt(vp.tablaPartida_I.getValueAt(fila, 0).toString());
                new PPartidaDAO().eliminarDatos(varCodCiaGlobalDeLogin, cod, tip);
            } else {
                showMessage1("Debe seleccionar una fila");
            }
        } else {
            fila = vp.tablaPartida_E.getSelectedRow();
            // System.out.println("La fila es" + fila);
            if (fila != -1) {
                //System.out.println("Hay filas seleccionadas.");
                cod = Integer.parseInt(vp.tablaPartida_E.getValueAt(fila, 0).toString());
                new PPartidaDAO().eliminarDatos(varCodCiaGlobalDeLogin, cod, tip);
            } else {
                showMessage1("Debe seleccionar una fila");
            }
        }
    }

    public void vaciarCampos() {
        vp.desPartida_E.setText("");
        vp.desPartida_I.setText("");
    }

    int codT;

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == vp.tUniMed_I) {
            Object item = vp.tUniMed_I.getSelectedItem();
            String value = ((SelectTabs) item).getValue();
            codT = Integer.parseInt(value);
            initListarElementos_I(codT);
        }

        if (e.getSource() == vp.tUniMed_E) {
            Object item = vp.tUniMed_E.getSelectedItem();
            String value = ((SelectTabs) item).getValue();
            codT = Integer.parseInt(value);
            initListarElementos_E(codT);
        }
    }
}