package Vistas;

import Modelo.Cliente;
import Modelo.DAO.ClienteDAO;
import Modelo.GenerarPDF.PDFEgresos;
import static Vistas.V_Login.varCodCiaGlobalDeLogin;
import javax.swing.JOptionPane;


public class V_Compra extends javax.swing.JPanel {

    public V_Compra() {
        initComponents();
        setOpaque(false);
    }
    
    public void init(){
        tablaCompra.fixTable(jScrollPane1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        dateChooser2 = new com.raven.datechooser.DateChooser();
        pictureBox1 = new Modelo.Design.PictureBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelShadow1 = new Modelo.Design.PanelShadow();
        pictureBox2 = new Modelo.Design.PictureBox();
        txtDesProveedor = new Modelo.Design.TextField();
        jLabel1 = new javax.swing.JLabel();
        codProveedor = new Modelo.Design.Combobox();
        panelShadow2 = new Modelo.Design.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCompra = new Modelo.DesignTable.Tabla();
        btnLimpiar = new Modelo.Design.Button();
        btnBorrar = new Modelo.Design.Button();
        btnGenerar = new Modelo.Design.Button();
        impMonto = new Modelo.Design.TextField();
        tipCambio = new Modelo.Design.TextField();
        impNetoMN = new Modelo.Design.TextField();
        impIGVMN = new Modelo.Design.TextField();
        impTotalMN = new Modelo.Design.TextField();
        eMoneda = new Modelo.Design.Combobox();
        pictureBox6 = new Modelo.Design.PictureBox();
        jLabel8 = new javax.swing.JLabel();
        fecCP = new Modelo.Design.TextField();
        fecAbono = new Modelo.Design.TextField();
        jButton1 = new javax.swing.JButton();
        panelShadow3 = new Modelo.Design.PanelShadow();
        pictureBox3 = new Modelo.Design.PictureBox();
        jLabel2 = new javax.swing.JLabel();
        codPyto = new Modelo.Design.Combobox();
        desPyto = new Modelo.Design.TextField();
        panelShadow4 = new Modelo.Design.PanelShadow();
        pictureBox4 = new Modelo.Design.PictureBox();
        jLabel5 = new javax.swing.JLabel();
        nroPago = new Modelo.Design.TextField();
        codEstado = new Modelo.Design.Combobox();
        eCompPago = new Modelo.Design.Combobox();
        textAreaScroll1 = new Modelo.Design.TextAreaScroll();
        desAbono = new Modelo.Design.TextArea();
        nroCP = new Modelo.Design.TextField();
        btnAgregar = new Modelo.Design.Button();
        btnTablaC = new Modelo.Design.ButtonCircle();
        btnTablaDetalleC = new Modelo.Design.ButtonCircle();
        panelShadow5 = new Modelo.Design.PanelShadow();
        pictureBox5 = new Modelo.Design.PictureBox();
        jLabel6 = new javax.swing.JLabel();
        codPartida = new Modelo.Design.Combobox();
        desPartida = new Modelo.Design.TextField();
        impNetoMNPart = new Modelo.Design.TextField();
        impIgvMNPart = new Modelo.Design.TextField();
        semilla = new Modelo.Design.TextField();

        dateChooser1.setTextRefernce(fecCP);

        dateChooser2.setTextRefernce(fecAbono);

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/compra.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(235, 235, 235));
        jLabel3.setText("¡Registre las compras!");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 179, 255));
        jLabel4.setText("Complete la información de sus compras");

        pictureBox2.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/lapiz_registro.png"))); // NOI18N

        txtDesProveedor.setEditable(false);
        txtDesProveedor.setLabelText("Nombre Proveedor");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Datos Proveedor");

        codProveedor.setLabeText("Cod. Proveedor");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(codProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(pictureBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(txtDesProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pictureBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(codProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDesProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        tablaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sec", "Cod. Partida", "Nombre Part.", "Semilla", "SubTotal", "IGV", "Total"
            }
        ));
        jScrollPane1.setViewportView(tablaCompra);

        btnLimpiar.setBackground(new java.awt.Color(211, 215, 252));
        btnLimpiar.setForeground(new java.awt.Color(51, 102, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/clean.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");

        btnBorrar.setBackground(new java.awt.Color(252, 221, 221));
        btnBorrar.setForeground(new java.awt.Color(255, 0, 0));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/borrar.png"))); // NOI18N
        btnBorrar.setText("Borrar");

        btnGenerar.setBackground(new java.awt.Color(221, 252, 234));
        btnGenerar.setForeground(new java.awt.Color(0, 153, 51));
        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dventa.png"))); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        impMonto.setLabelText("Monto");

        tipCambio.setLabelText("Tipo Cambio");

        impNetoMN.setEditable(false);
        impNetoMN.setLabelText("SubTotal");

        impIGVMN.setEditable(false);
        impIGVMN.setLabelText("IGV 18%");

        impTotalMN.setEditable(false);
        impTotalMN.setLabelText("Total");

        eMoneda.setLabeText("Moneda");

        pictureBox6.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/lapiz_registro.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Fechas");

        fecCP.setLabelText("Fecha Compra");

        fecAbono.setLabelText("Fecha Abono");

        jButton1.setText("Generar PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(impMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tipCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(impNetoMN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(impIGVMN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(impTotalMN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelShadow2Layout.createSequentialGroup()
                            .addComponent(fecCP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fecAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow2Layout.createSequentialGroup()
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnGenerar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pictureBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(impMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(impNetoMN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(impIGVMN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(impTotalMN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        panelShadow3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pictureBox3.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/lapiz_registro.png"))); // NOI18N
        panelShadow3.add(pictureBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 25, 25));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Datos Proyecto");
        panelShadow3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 25));

        codPyto.setLabeText("Proyecto");
        panelShadow3.add(codPyto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 44));

        desPyto.setEditable(false);
        desPyto.setLabelText("Nombre Proyecto");
        panelShadow3.add(desPyto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 140, -1));

        panelShadow4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pictureBox4.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/lapiz_registro.png"))); // NOI18N
        panelShadow4.add(pictureBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 25, 25));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Datos Generales");
        panelShadow4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, 25));

        nroPago.setLabelText("Num Pago");
        panelShadow4.add(nroPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 100, -1));

        codEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disponible", "No Disp.", "Reservado" }));
        codEstado.setSelectedIndex(-1);
        codEstado.setLabeText("Estado");
        panelShadow4.add(codEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, -1));

        eCompPago.setLabeText("CompPago");
        panelShadow4.add(eCompPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 40));

        textAreaScroll1.setLabelText("Desc. Abono");

        desAbono.setColumns(20);
        desAbono.setRows(5);
        textAreaScroll1.setViewportView(desAbono);

        panelShadow4.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, 60));

        nroCP.setLabelText("Num Compra");
        panelShadow4.add(nroCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 100, -1));

        btnAgregar.setBackground(new java.awt.Color(236, 76, 124));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N

        btnTablaC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnTablaC.setToolTipText("ver tabla compra");

        btnTablaDetalleC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnTablaDetalleC.setToolTipText("ver tabla detalle compra");

        pictureBox5.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/lapiz_registro.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Datos Partida");

        codPartida.setLabeText("Partida");

        desPartida.setEditable(false);
        desPartida.setLabelText("Desc. Partida");

        impNetoMNPart.setLabelText("ImpNeto");

        impIgvMNPart.setLabelText("IGV");

        semilla.setLabelText("Semilla");

        javax.swing.GroupLayout panelShadow5Layout = new javax.swing.GroupLayout(panelShadow5);
        panelShadow5.setLayout(panelShadow5Layout);
        panelShadow5Layout.setHorizontalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow5Layout.createSequentialGroup()
                        .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(desPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codPartida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(impNetoMNPart, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(impIgvMNPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(semilla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelShadow5Layout.setVerticalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow5Layout.createSequentialGroup()
                        .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pictureBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(codPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow5Layout.createSequentialGroup()
                        .addComponent(impNetoMNPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(impIgvMNPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(semilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desPartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnTablaC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTablaDetalleC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelShadow5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTablaC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(btnTablaDetalleC, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelShadow5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarActionPerformed

    
    public javax.swing.JTable getTablaCompra() {
        return tablaCompra;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int codCia = varCodCiaGlobalDeLogin; // Suponiendo que tienes esta variable global con el código de la compañía
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente clienteActual = clienteDAO.obtenerClienteActual(codCia);

        String nombreEmpresa = clienteActual.getDesPersona();
        String ruc = clienteActual.getNroRuc();

        
        PDFEgresos pdf = new PDFEgresos();
        pdf.generarPDF(tablaCompra, nombreEmpresa, ruc);
        JOptionPane.showMessageDialog(this, "PDF generado exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Modelo.Design.Button btnAgregar;
    public Modelo.Design.Button btnBorrar;
    public Modelo.Design.Button btnGenerar;
    public Modelo.Design.Button btnLimpiar;
    public Modelo.Design.ButtonCircle btnTablaC;
    public Modelo.Design.ButtonCircle btnTablaDetalleC;
    public Modelo.Design.Combobox codEstado;
    public Modelo.Design.Combobox codPartida;
    public Modelo.Design.Combobox codProveedor;
    public Modelo.Design.Combobox codPyto;
    public com.raven.datechooser.DateChooser dateChooser1;
    public com.raven.datechooser.DateChooser dateChooser2;
    public Modelo.Design.TextArea desAbono;
    public Modelo.Design.TextField desPartida;
    public Modelo.Design.TextField desPyto;
    public Modelo.Design.Combobox eCompPago;
    public Modelo.Design.Combobox eMoneda;
    public Modelo.Design.TextField fecAbono;
    public Modelo.Design.TextField fecCP;
    public Modelo.Design.TextField impIGVMN;
    public Modelo.Design.TextField impIgvMNPart;
    public Modelo.Design.TextField impMonto;
    public Modelo.Design.TextField impNetoMN;
    public Modelo.Design.TextField impNetoMNPart;
    public Modelo.Design.TextField impTotalMN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public Modelo.Design.TextField nroCP;
    public Modelo.Design.TextField nroPago;
    private Modelo.Design.PanelShadow panelShadow1;
    private Modelo.Design.PanelShadow panelShadow2;
    private Modelo.Design.PanelShadow panelShadow3;
    private Modelo.Design.PanelShadow panelShadow4;
    private Modelo.Design.PanelShadow panelShadow5;
    private Modelo.Design.PictureBox pictureBox1;
    private Modelo.Design.PictureBox pictureBox2;
    private Modelo.Design.PictureBox pictureBox3;
    private Modelo.Design.PictureBox pictureBox4;
    private Modelo.Design.PictureBox pictureBox5;
    private Modelo.Design.PictureBox pictureBox6;
    public Modelo.Design.TextField semilla;
    public Modelo.DesignTable.Tabla tablaCompra;
    private Modelo.Design.TextAreaScroll textAreaScroll1;
    public Modelo.Design.TextField tipCambio;
    public Modelo.Design.TextField txtDesProveedor;
    // End of variables declaration//GEN-END:variables
}
