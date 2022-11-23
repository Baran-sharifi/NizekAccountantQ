package nizekAccountant;

//import testProject.ButtonRounder;
import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.Login.Costumer;
import nizekAccountant.logic.Login.GroupType;
import nizekAccountant.logic.ModelManager.Manager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import nizekAccountant.logic.AccountingCalculations.Accounting;
import static nizekAccountant.logic.ModelManager.Manager.userRepository;
import nizekAccountant.logic.UserRepository.UserRepository;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author Lenovo
 */
public class DashboardMenu extends javax.swing.JFrame {

    int addDocCounter = 0;
    int addCheckCounter = 0;
    boolean submitDocs = false;
    Dimension dimension = new Dimension(72, 26);
    Dimension Docs = new Dimension(100, 100);
    private LoginLogic loginLogic;
    private AddCheckLogic addCheckLogic;
    private AddDocLogic addDocLogic;
    private AddUserLogic addUserLogic;
    private ChangeStateCheckLogic changeStateCheckLogic;
    private ShowDocRepository docRepo;
    private ShowPeopleRepository peopleRepo;
    private ShowCheckRepository checkRepo;

    private FilterChecks filterChecks;
    private FilterDocs filterDocs;
    private GraphicsManager btnmanager;
    //  private ButtonRounder btnRounder;
    GroupType b = new GroupType("مشتری");
    String checkFilter;
    String docFilter;

    public DashboardMenu() {
        initComponents();
        btnmanager = new GraphicsManager(102, 102, 255, dimension);
        landPage(dashboard);
        disableFilter();
        SliderListener();
        // Test



//
//filteringChecks.setEnabled(false);
//filteringDocs.setEnabled(false);
        UserRepository userRepository = new UserRepository();
        userRepository.readAndAddCostumer(new File("C:\\csvProject\\costumerFile.csv"));
        userRepository.readAndAddCheckDoc(new File("C:\\csvProject\\checkFile.csv"));
        userRepository.readAndAddNormalDoc(new File("C:\\csvProject\\normalFile.csv"));
        checkSlider1.setMaximum((int)userRepository.getMaxCheckDoc());//add check add doc
        checkSlider2.setMaximum((int)userRepository.getMaxCheckDoc());
        docSlider1.setMaximum((int)userRepository.getMaxCheckDoc());//add check add doc
        docSlider2.setMaximum((int)userRepository.getMaxCheckDoc());
        DefaultComboBoxModel<String> defaultComboBoxModel1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> defaultComboBoxModel2 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> defaultComboBoxModel3 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> defaultComboBoxModel4 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> defaultComboBoxModel5 = new DefaultComboBoxModel<>();
//============comboBoxes setting==============================================        
        payeesComboBox.setModel(defaultComboBoxModel1);
        for (Costumer item : Manager.costumerList) {
            defaultComboBoxModel1.addElement(item.getName());

        }

        peopleDocList.setModel(defaultComboBoxModel2);
        for (Costumer item : Manager.costumerList) {
            defaultComboBoxModel2.addElement(item.getName());

        }

        peopleCheckList.setModel(defaultComboBoxModel3);
        for (Costumer item : Manager.costumerList) {
            defaultComboBoxModel3.addElement(item.getName());

        }

        addDocCombo.setModel(defaultComboBoxModel4);
        for (Costumer item : Manager.costumerList) {
            defaultComboBoxModel4.addElement(item.getName());

        }

        changeStateComboBox.setModel(defaultComboBoxModel5);
        for (Costumer item : Manager.costumerList) {
            defaultComboBoxModel5.addElement(item.getName());

        }

        addCheckLogic = new AddCheckLogic();
        addDocLogic = new AddDocLogic();
        addUserLogic = new AddUserLogic();

        changeStateCheckLogic = new ChangeStateCheckLogic();

        checkRepo = new ShowCheckRepository();
        peopleRepo = new ShowPeopleRepository();
        docRepo = new ShowDocRepository();

        checksTable.setModel(checkRepo);
        docsTable.setModel(docRepo);
        peopleTable.setModel(peopleRepo);
        //   ButtonRounder btnRounder =new ButtonRounder(10);
  
        checkSlider1.setMaximum(10000);
        checkSlider1.setMaximum(10000);

//===========changing button colors====================
        btnmanager.btnChangeColor(filteringChecks);
        btnmanager.btnChangeColor(filteringDocs);
        btnmanager.btnChangeColor(addPeopleback);
        btnmanager.btnChangeColor(passWordRecovery);
        btnmanager.btnChangeColor(enterBtn);
        btnmanager.btnChangeColor(signInbtn);
        btnmanager.btnChangeColor(registerCheck);
        btnmanager.btnChangeColor(addCheckBack);
        btnmanager.btnChangeColor(registerChangeCheck);
        btnmanager.toggleChangeColor(isCreditorToggle);
        btnmanager.btnChangeColor(backCheckState);
        btnmanager.btnChangeColor(submitDoc);
        btnmanager.btnChangeColor(addDocback);
        btnmanager.btnChangeColor(btnconfirm);
        btnmanager.btnChangeColor(addcategory);
        btnmanager.btnChangeColor(addback);
        btnmanager.btnChangeColor(confirmCategory);
        btnmanager.btnChangeColor(dashboardBtnshowCheck);
        btnmanager.btnChangeColor(addUserBtn);
        btnmanager.btnChangeColor(dashboardBtnshowDoc);
        btnmanager.btnChangeColor(dashboardBtnadd);
        btnmanager.btnChangeColor(dashboardBtnaddDoc);
        btnmanager.btnChangeColor(backshowDoc1);
        btnmanager.btnChangeColor(backshowDoc);
        btnmanager.btnChangeColor(ShowDocsbtn);
        btnmanager.btnChangeColor(backshowCheck1);
        btnmanager.btnChangeColor(backshowCheck);
        btnmanager.btnChangeColor(backToLogin);
        btnmanager.btnChangeColor(tarazBtn);
        btnmanager.btnChangeColor(ShowChecksbtn);
        btnmanager.btnChangeColor(dashboardBtnshowCheck1);
        btnmanager.btnChangeColor(showPeople);
        btnmanager.btnChangeColor(filteringDocs);
        btnmanager.btnChangeColor(convertToDoc);
        btnmanager.btnChangeColor(chartBtn);
        //=============changing lables===========================
        //============changing size  the registered buttons ============================
        btnmanager.btnSize(submitDoc);
        btnmanager.btnSize(registerChangeCheck);
        btnmanager.btnSize(btnconfirm);
        btnmanager.btnSize(registerCheck);
        btnmanager.btnSize(confirmCategory);
    }
    //==================================================================

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        loginPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        timeFilter = new javax.swing.ButtonGroup();
        filters = new javax.swing.ButtonGroup();
        LoginPanel = new javax.swing.JPanel();
        emailfieldLogin = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        passWordRecovery = new javax.swing.JButton();
        enterBtn = new javax.swing.JButton();
        signInbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        addcheckPanel = new javax.swing.JPanel();
        registerCheck = new javax.swing.JButton();
        addCheckBack = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        addCheckScroll = new javax.swing.JScrollPane();
        addingCheckPanel = new javax.swing.JPanel();
        discriptionCheck = new javax.swing.JScrollPane();
        discriptionTextAdd = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        payeeCostAdd = new javax.swing.JTextField();
        TimeCheckAddDay = new javax.swing.JTextField();
        isCashedBtn = new javax.swing.JRadioButton();
        payeesComboBox = new javax.swing.JComboBox<>();
        TimeCheckAddYear = new javax.swing.JTextField();
        TimeCheckAddMonth = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        addCheckBack1 = new javax.swing.JButton();
        countCheck = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        stateChangePanel = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        checkIdentifier = new javax.swing.JTextField();
        registerChangeCheck = new javax.swing.JButton();
        isCreditorToggle = new javax.swing.JToggleButton();
        backCheckState = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        changeStateComboBox = new javax.swing.JComboBox<>();
        convertToDoc = new javax.swing.JButton();
        showDocPanel = new javax.swing.JPanel();
        payeeLabel = new javax.swing.JLabel();
        ShowDocsbtn = new javax.swing.JButton();
        backshowDoc = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        daily = new javax.swing.JRadioButton();
        weeklyDoc = new javax.swing.JRadioButton();
        MonthlyDoc = new javax.swing.JRadioButton();
        monthsDocCombo = new javax.swing.JComboBox<>();
        peopleDocList = new javax.swing.JComboBox<>();
        costLabel = new javax.swing.JLabel();
        TimeDocRBtn = new javax.swing.JRadioButton();
        payeeDocRBtn = new javax.swing.JRadioButton();
        costDocRBtn = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        DRangeDocsMonthFrom = new javax.swing.JTextField();
        DRangeDocsDayFrom = new javax.swing.JTextField();
        DRangeDocsmonthTo = new javax.swing.JTextField();
        DRangeDocsDayTo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        DRangeDocsYearFrom = new javax.swing.JTextField();
        DRangeDocsYearTo = new javax.swing.JTextField();
        docSlider1 = new javax.swing.JSlider();
        docSlider2 = new javax.swing.JSlider();
        jLabel57 = new javax.swing.JLabel();
        DocCostFrom = new javax.swing.JLabel();
        DocCostTo = new javax.swing.JLabel();
        filteringDocs = new javax.swing.JButton();
        addDocPanel = new javax.swing.JPanel();
        scrollDoc = new javax.swing.JScrollPane();
        addingDocPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        discriptionDocAdd = new javax.swing.JTextField();
        costDocAdd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        creditorBtn = new javax.swing.JRadioButton();
        debtorBtn = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        addDocCombo = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        docMonth = new javax.swing.JTextField();
        docDay = new javax.swing.JTextField();
        docYear = new javax.swing.JTextField();
        submitDoc = new javax.swing.JButton();
        addDocback = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        groupDocSubmit = new javax.swing.JButton();
        countDoc = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        addPeoplePanel = new javax.swing.JPanel();
        addName = new javax.swing.JTextField();
        addId = new javax.swing.JTextField();
        AddressField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        employeeBtn = new javax.swing.JRadioButton();
        clientBtn = new javax.swing.JRadioButton();
        partnerBtn = new javax.swing.JRadioButton();
        btnconfirm = new javax.swing.JButton();
        addcategory = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        addPeopleback = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        addCategoryPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        categoryField = new javax.swing.JTextField();
        confirmCategory = new javax.swing.JButton();
        addback = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        categoryFieldName = new javax.swing.JTextField();
        categoryFieldEmail = new javax.swing.JTextField();
        categoryFieldId = new javax.swing.JTextField();
        categoryFieldPhone = new javax.swing.JTextField();
        categoryFieldَAddress = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        dashboard = new javax.swing.JPanel();
        dashboardBtnshowCheck = new javax.swing.JButton();
        addUserBtn = new javax.swing.JButton();
        dashboardBtnshowDoc = new javax.swing.JButton();
        dashboardBtnadd = new javax.swing.JButton();
        dashboardBtnaddDoc = new javax.swing.JButton();
        dashboardlabel = new javax.swing.JLabel();
        tarazBtn = new javax.swing.JButton();
        backToLogin = new javax.swing.JButton();
        dashboardBtnshowCheck1 = new javax.swing.JButton();
        showPeople = new javax.swing.JButton();
        chartBtn = new javax.swing.JButton();
        showCheckpanel = new javax.swing.JPanel();
        payeeLabelCheck = new javax.swing.JLabel();
        ShowChecksbtn = new javax.swing.JButton();
        backshowDoc1 = new javax.swing.JButton();
        dailyCheckRBtn = new javax.swing.JRadioButton();
        weeklyCheckRBtn = new javax.swing.JRadioButton();
        MonthlyCheckRBtn = new javax.swing.JRadioButton();
        monthscheckCombo = new javax.swing.JComboBox<>();
        peopleCheckList = new javax.swing.JComboBox<>();
        costLabelCheck = new javax.swing.JLabel();
        TimeCheckRBtn = new javax.swing.JRadioButton();
        payeeCheckRBtn = new javax.swing.JRadioButton();
        costCheckRBtn = new javax.swing.JRadioButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        DRangeChecksYear = new javax.swing.JTextField();
        DRangeChecksMonth = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DRangeDocsYear2 = new javax.swing.JTextField();
        DRangeDocsMonth2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        DRangeChecksYear1 = new javax.swing.JTextField();
        DRangeDocsDay3 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        checkSlider1 = new javax.swing.JSlider();
        sliderCheckLabel = new javax.swing.JLabel();
        checkSlider2 = new javax.swing.JSlider();
        checkCostFrom = new javax.swing.JLabel();
        checkCostTo = new javax.swing.JLabel();
        filteringChecks = new javax.swing.JButton();
        checksReport = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        checksTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        backshowCheck = new javax.swing.JButton();
        checkWeightLabel = new javax.swing.JLabel();
        docsReport = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        docsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        backshowCheck1 = new javax.swing.JButton();
        peopleReports = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        peopleTable = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        backshowCheck2 = new javax.swing.JButton();
        tarazName = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        backshowCheck3 = new javax.swing.JButton();
        chart = new javax.swing.JPanel();
        backshowCheck4 = new javax.swing.JButton();
        filteredDocs = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        filteredDocTable = new javax.swing.JTable();
        jLabel59 = new javax.swing.JLabel();
        backshowCheck5 = new javax.swing.JButton();
        filteredChecks = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        filteredCheckTable = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        backshowCheck6 = new javax.swing.JButton();

        jFrame1.setTitle("checkFrame");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(102, 102, 102));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        LoginPanel.setBackground(new java.awt.Color(153, 153, 153));

        emailfieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailfieldLoginActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("نام کاربری و رمز عبور را وارد کنید");

        passWordRecovery.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        passWordRecovery.setText("رمز عبور را فراموش کردید؟ ");
        passWordRecovery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passWordRecoveryActionPerformed(evt);
            }
        });

        enterBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        enterBtn.setText("ورود");
        enterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBtnActionPerformed(evt);
            }
        });

        signInbtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        signInbtn.setText("ثبت نام");

        jLabel3.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ایمیل");

        jLabel21.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("رمز عبور");

        jLabel22.setBackground(new java.awt.Color(102, 102, 255));
        jLabel22.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("پنل ورود ");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(LoginPanelLayout.createSequentialGroup()
                                    .addComponent(emailfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(LoginPanelLayout.createSequentialGroup()
                                    .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(LoginPanelLayout.createSequentialGroup()
                                            .addComponent(enterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(LoginPanelLayout.createSequentialGroup()
                                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)))
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(LoginPanelLayout.createSequentialGroup()
                                    .addGap(308, 308, 308)
                                    .addComponent(jLabel22)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                                .addComponent(passWordRecovery, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signInbtn)
                                .addGap(165, 165, 165)))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(48, 48, 48)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(enterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInbtn)
                    .addComponent(passWordRecovery))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        addcheckPanel.setBackground(new java.awt.Color(153, 153, 153));

        registerCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        registerCheck.setText("ثبت");
        registerCheck.setPreferredSize(dimension);
        registerCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerCheckActionPerformed(evt);
            }
        });

        addCheckBack.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addCheckBack.setText("بازگشت به داشبورد اصلی");
        addCheckBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCheckBackActionPerformed(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(102, 102, 255));
        jLabel29.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("افزودن چک");

        addingCheckPanel.setBackground(new java.awt.Color(102, 102, 102));

        discriptionTextAdd.setColumns(20);
        discriptionTextAdd.setRows(5);
        discriptionCheck.setViewportView(discriptionTextAdd);

        jLabel17.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("طرف حساب");

        jLabel18.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("مبلغ");

        jLabel19.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("توضیحات");

        payeeCostAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payeeCostAddActionPerformed(evt);
            }
        });

        TimeCheckAddDay.setBackground(new java.awt.Color(102, 102, 102));
        TimeCheckAddDay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        TimeCheckAddDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeCheckAddDayActionPerformed(evt);
            }
        });

        isCashedBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        isCashedBtn.setForeground(new java.awt.Color(255, 255, 255));
        isCashedBtn.setText("وصول شده است");

        payeesComboBox.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        payeesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " ", " ", " ", " " }));
        payeesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payeesComboBoxActionPerformed(evt);
            }
        });

        TimeCheckAddYear.setBackground(new java.awt.Color(102, 102, 102));
        TimeCheckAddYear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        TimeCheckAddYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeCheckAddYearActionPerformed(evt);
            }
        });

        TimeCheckAddMonth.setBackground(new java.awt.Color(102, 102, 102));
        TimeCheckAddMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        TimeCheckAddMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeCheckAddMonthActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("/");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("/");

        javax.swing.GroupLayout addingCheckPanelLayout = new javax.swing.GroupLayout(addingCheckPanel);
        addingCheckPanel.setLayout(addingCheckPanelLayout);
        addingCheckPanelLayout.setHorizontalGroup(
            addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingCheckPanelLayout.createSequentialGroup()
                .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addingCheckPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingCheckPanelLayout.createSequentialGroup()
                                .addComponent(isCashedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(366, 366, 366))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingCheckPanelLayout.createSequentialGroup()
                                .addComponent(discriptionCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94))))
                    .addGroup(addingCheckPanelLayout.createSequentialGroup()
                        .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addingCheckPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(payeeCostAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addingCheckPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(TimeCheckAddYear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TimeCheckAddMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TimeCheckAddDay, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(payeesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addingCheckPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17))
                            .addGroup(addingCheckPanelLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel18))))
                    .addGroup(addingCheckPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel19)))
                .addGap(107, 107, 107))
        );
        addingCheckPanelLayout.setVerticalGroup(
            addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingCheckPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addingCheckPanelLayout.createSequentialGroup()
                        .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(payeesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TimeCheckAddDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TimeCheckAddYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TimeCheckAddMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(addingCheckPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payeeCostAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discriptionCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(11, 11, 11)
                .addComponent(isCashedBtn)
                .addGap(61, 61, 61))
        );

        addCheckScroll.setViewportView(addingCheckPanel);

        addCheckBack1.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addCheckBack1.setText("+");
        addCheckBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCheckBack1ActionPerformed(evt);
            }
        });

        countCheck.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countCheck.setText(" ");

        jLabel56.setFont(new java.awt.Font("B Roya", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("ثبت چک ققط برای طرف حساب های ثبت شده قابل انجام است");

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("افزودن شخص جدید");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addcheckPanelLayout = new javax.swing.GroupLayout(addcheckPanel);
        addcheckPanel.setLayout(addcheckPanelLayout);
        addcheckPanelLayout.setHorizontalGroup(
            addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addcheckPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addGroup(addcheckPanelLayout.createSequentialGroup()
                        .addComponent(countCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addcheckPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addCheckBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addCheckBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
            .addGroup(addcheckPanelLayout.createSequentialGroup()
                .addGroup(addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addcheckPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(addCheckScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addcheckPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 80, Short.MAX_VALUE))
        );
        addcheckPanelLayout.setVerticalGroup(
            addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addcheckPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(addCheckScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(countCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(84, 84, 84)
                .addGroup(addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCheckBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCheckBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        stateChangePanel.setBackground(new java.awt.Color(102, 102, 102));

        jLabel25.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("طرف حساب");

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("شناسه چک");

        checkIdentifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIdentifierActionPerformed(evt);
            }
        });

        registerChangeCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        registerChangeCheck.setText("ثبت");
        registerChangeCheck.setPreferredSize(dimension);
        registerChangeCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerChangeCheckActionPerformed(evt);
            }
        });

        isCreditorToggle.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        isCreditorToggle.setText("وصول شده است");
        isCreditorToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isCreditorToggleActionPerformed(evt);
            }
        });

        backCheckState.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backCheckState.setText("بازگشت به داشبورد اصلی");
        backCheckState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backCheckStateActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(102, 102, 255));
        jLabel30.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("تغییر وضعیت چک");

        convertToDoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        convertToDoc.setText("تبدیل چک به سند");
        convertToDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertToDocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stateChangePanelLayout = new javax.swing.GroupLayout(stateChangePanel);
        stateChangePanel.setLayout(stateChangePanelLayout);
        stateChangePanelLayout.setHorizontalGroup(
            stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stateChangePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addContainerGap())
            .addGroup(stateChangePanelLayout.createSequentialGroup()
                .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(stateChangePanelLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(changeStateComboBox, 0, 238, Short.MAX_VALUE)
                            .addComponent(checkIdentifier))
                        .addGap(47, 47, 47)
                        .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)))
                    .addGroup(stateChangePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backCheckState)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerChangeCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)))
                .addGap(0, 159, Short.MAX_VALUE))
            .addGroup(stateChangePanelLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(isCreditorToggle, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(convertToDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stateChangePanelLayout.setVerticalGroup(
            stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stateChangePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stateChangePanelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(changeStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26))
                    .addGroup(stateChangePanelLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(checkIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(isCreditorToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(convertToDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerChangeCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backCheckState, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        showDocPanel.setBackground(new java.awt.Color(153, 153, 153));

        payeeLabel.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        payeeLabel.setForeground(new java.awt.Color(255, 255, 255));
        payeeLabel.setText("طرف حساب");

        ShowDocsbtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        ShowDocsbtn.setText("نمایش سندها");
        ShowDocsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowDocsbtnActionPerformed(evt);
            }
        });

        backshowDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowDoc.setText("بازگشت به داشبورد اصلی");
        backshowDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowDocActionPerformed(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(102, 102, 255));
        jLabel31.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("نمایش سند");

        timeFilter.add(daily);
        daily.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        daily.setForeground(new java.awt.Color(255, 255, 255));
        daily.setText("روزانه");
        daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyActionPerformed(evt);
            }
        });

        timeFilter.add(weeklyDoc);
        weeklyDoc.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        weeklyDoc.setForeground(new java.awt.Color(255, 255, 255));
        weeklyDoc.setText("هفتگی");

        timeFilter.add(MonthlyDoc);
        MonthlyDoc.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        MonthlyDoc.setForeground(new java.awt.Color(255, 255, 255));
        MonthlyDoc.setText("ماهانه");
        MonthlyDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyDocActionPerformed(evt);
            }
        });

        monthsDocCombo.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        monthsDocCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد ", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن ", "اسفند" }));
        monthsDocCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthsDocComboActionPerformed(evt);
            }
        });

        peopleDocList.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        peopleDocList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleDocListActionPerformed(evt);
            }
        });

        costLabel.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        costLabel.setForeground(new java.awt.Color(255, 255, 255));
        costLabel.setText("مبلغ");

        filters.add(TimeDocRBtn);
        TimeDocRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        TimeDocRBtn.setForeground(new java.awt.Color(255, 255, 255));
        TimeDocRBtn.setText("فیلتر زمان");
        TimeDocRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeDocRBtnActionPerformed(evt);
            }
        });

        filters.add(payeeDocRBtn);
        payeeDocRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        payeeDocRBtn.setForeground(new java.awt.Color(255, 255, 255));
        payeeDocRBtn.setText("طرف حساب");
        payeeDocRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payeeDocRBtnActionPerformed(evt);
            }
        });

        filters.add(costDocRBtn);
        costDocRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        costDocRBtn.setForeground(new java.awt.Color(255, 255, 255));
        costDocRBtn.setText("فیلتر قیمت");
        costDocRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costDocRBtnActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("فیلترها");

        jLabel23.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("بازه ی زمانی مورد نظر را وارد کنید");

        DRangeDocsMonthFrom.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsMonthFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsMonthFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        DRangeDocsDayFrom.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsDayFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsDayFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        DRangeDocsDayFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DRangeDocsDayFromActionPerformed(evt);
            }
        });

        DRangeDocsmonthTo.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsmonthTo.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsmonthTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        DRangeDocsmonthTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DRangeDocsmonthToActionPerformed(evt);
            }
        });

        DRangeDocsDayTo.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsDayTo.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsDayTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel8.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("از تاریخ");

        jLabel27.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("تا تاریخ");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("/");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("/");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("/");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("/");

        DRangeDocsYearFrom.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsYearFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsYearFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        DRangeDocsYearTo.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsYearTo.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsYearTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        docSlider1.setBackground(new java.awt.Color(255, 255, 255));
        docSlider1.setForeground(new java.awt.Color(51, 51, 255));

        docSlider2.setBackground(new java.awt.Color(255, 255, 255));
        docSlider2.setForeground(new java.awt.Color(51, 102, 255));

        DocCostFrom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DocCostFrom.setForeground(new java.awt.Color(255, 255, 255));
        DocCostFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "از", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        DocCostTo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DocCostTo.setForeground(new java.awt.Color(255, 255, 255));
        DocCostTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "تا", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        filteringDocs.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        filteringDocs.setText("اعمال فیلتر");
        filteringDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filteringDocsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showDocPanelLayout = new javax.swing.GroupLayout(showDocPanel);
        showDocPanel.setLayout(showDocPanelLayout);
        showDocPanelLayout.setHorizontalGroup(
            showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDocPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addComponent(DRangeDocsYearTo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DRangeDocsmonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                        .addComponent(DRangeDocsYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addGap(9, 9, 9)
                        .addComponent(DRangeDocsMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)))
                .addGap(18, 18, 18)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DRangeDocsDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DRangeDocsDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addComponent(backshowDoc)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showDocPanelLayout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(jLabel31))
                            .addGroup(showDocPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ShowDocsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filteringDocs))))
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                                .addComponent(monthsDocCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MonthlyDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(weeklyDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(daily, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                                .addComponent(DocCostFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(87, 87, 87)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TimeDocRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(costDocRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(payeeDocRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addComponent(docSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DocCostTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(175, 175, 175)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(payeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peopleDocList, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))))
        );
        showDocPanelLayout.setVerticalGroup(
            showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showDocPanelLayout.createSequentialGroup()
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(daily)
                            .addComponent(weeklyDoc)
                            .addComponent(MonthlyDoc)
                            .addComponent(monthsDocCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel57))
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel31)
                        .addGap(26, 26, 26)
                        .addComponent(payeeDocRBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimeDocRBtn)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costDocRBtn)))
                .addGap(32, 32, 32)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DocCostFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(docSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(showDocPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(costLabel)))
                        .addGap(12, 12, 12)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DocCostTo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(docSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(payeeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(peopleDocList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DRangeDocsmonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeDocsDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(DRangeDocsYearTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DRangeDocsMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel48)
                                .addComponent(jLabel51)
                                .addComponent(DRangeDocsYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(DRangeDocsDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backshowDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowDocsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filteringDocs, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );

        addDocPanel.setBackground(new java.awt.Color(153, 153, 153));
        addDocPanel.setForeground(new java.awt.Color(204, 204, 204));

        scrollDoc.setBackground(new java.awt.Color(204, 255, 153));

        addingDocPanel.setBackground(new java.awt.Color(102, 102, 102));
        addingDocPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setBackground(new java.awt.Color(153, 153, 153));
        jLabel15.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("مبلغ");

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("توضیحات");

        costDocAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costDocAddActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("مشخصات سند");

        creditorBtn.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup2.add(creditorBtn);
        creditorBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        creditorBtn.setForeground(new java.awt.Color(255, 255, 255));
        creditorBtn.setText("بستانکار");

        debtorBtn.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup2.add(debtorBtn);
        debtorBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        debtorBtn.setForeground(new java.awt.Color(255, 255, 255));
        debtorBtn.setText("بدهکار");

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("طرف حساب");

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("______________________________________________________________________________________________________________________________");

        docMonth.setBackground(new java.awt.Color(102, 102, 102));
        docMonth.setForeground(new java.awt.Color(255, 255, 255));
        docMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        docMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docMonthActionPerformed(evt);
            }
        });

        docDay.setBackground(new java.awt.Color(102, 102, 102));
        docDay.setForeground(new java.awt.Color(255, 255, 255));
        docDay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        docYear.setBackground(new java.awt.Color(102, 102, 102));
        docYear.setForeground(new java.awt.Color(255, 255, 255));
        docYear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout addingDocPanelLayout = new javax.swing.GroupLayout(addingDocPanel);
        addingDocPanel.setLayout(addingDocPanelLayout);
        addingDocPanelLayout.setHorizontalGroup(
            addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingDocPanelLayout.createSequentialGroup()
                .addGap(0, 48, Short.MAX_VALUE)
                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addingDocPanelLayout.createSequentialGroup()
                        .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(addingDocPanelLayout.createSequentialGroup()
                                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(creditorBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(debtorBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(addingDocPanelLayout.createSequentialGroup()
                                .addComponent(docYear, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(docMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(docDay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))
                        .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(costDocAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(discriptionDocAdd)
                            .addComponent(addDocCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16))
                            .addComponent(jLabel13)))
                    .addGroup(addingDocPanelLayout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addGap(21, 21, 21))
        );
        addingDocPanelLayout.setVerticalGroup(
            addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingDocPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addingDocPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(creditorBtn)
                            .addComponent(addDocCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(costDocAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(debtorBtn))
                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addingDocPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel16))
                    .addGroup(addingDocPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(discriptionDocAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(docMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(docDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(docYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38)
                .addComponent(jLabel39)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        scrollDoc.setViewportView(addingDocPanel);

        submitDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        submitDoc.setText("ثبت");
        submitDoc.setPreferredSize(dimension);
        submitDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitDocActionPerformed(evt);
            }
        });

        addDocback.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addDocback.setText("بازگشت به داشبورد اصلی");
        addDocback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocbackActionPerformed(evt);
            }
        });

        jLabel32.setBackground(new java.awt.Color(102, 102, 255));
        jLabel32.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("افزودن سند");

        groupDocSubmit.setBackground(new java.awt.Color(153, 153, 255));
        groupDocSubmit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        groupDocSubmit.setForeground(new java.awt.Color(255, 255, 255));
        groupDocSubmit.setText("+ ");
        groupDocSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupDocSubmitActionPerformed(evt);
            }
        });

        countDoc.setText(" ");

        jLabel55.setFont(new java.awt.Font("B Roya", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("ثبت سند فقط برای طرف حساب های ثبت شده قابل انجام است");

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("افزودن شخص جدید");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addDocPanelLayout = new javax.swing.GroupLayout(addDocPanel);
        addDocPanel.setLayout(addDocPanelLayout);
        addDocPanelLayout.setHorizontalGroup(
            addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addDocPanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocPanelLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(32, 32, 32))
                    .addGroup(addDocPanelLayout.createSequentialGroup()
                        .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addDocPanelLayout.createSequentialGroup()
                                .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(232, 232, 232)
                                .addComponent(countDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addDocPanelLayout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(addDocback)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupDocSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        addDocPanelLayout.setVerticalGroup(
            addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDocback, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupDocSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addDocPanelLayout.createSequentialGroup()
                        .addComponent(scrollDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                        .addComponent(countDoc)
                        .addGap(35, 35, 35))
                    .addGroup(addDocPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(76, 76, 76)))
                .addGap(93, 93, 93))
        );

        addPeoplePanel.setBackground(new java.awt.Color(153, 153, 153));
        addPeoplePanel.setForeground(new java.awt.Color(255, 255, 255));

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        buttonGroup1.add(employeeBtn);
        employeeBtn.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        employeeBtn.setForeground(new java.awt.Color(255, 255, 255));
        employeeBtn.setText("کارمند");
        employeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(clientBtn);
        clientBtn.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        clientBtn.setForeground(new java.awt.Color(255, 255, 255));
        clientBtn.setText("مشتری");
        clientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(partnerBtn);
        partnerBtn.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        partnerBtn.setForeground(new java.awt.Color(255, 255, 255));
        partnerBtn.setText("شریک تجاری");
        partnerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partnerBtnActionPerformed(evt);
            }
        });

        btnconfirm.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        btnconfirm.setText("ثبت");
        btnconfirm.setPreferredSize(dimension);
        btnconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmActionPerformed(evt);
            }
        });

        addcategory.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        addcategory.setText("افزودن دسته بندی جدید");
        addcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcategoryActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("نام ");

        jLabel9.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("کد ملی");

        jLabel10.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("شماره تلفن");

        jLabel11.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ایمیل");

        jLabel12.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("آدرس");

        addPeopleback.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addPeopleback.setText("بازگشت به داشبورد اصلی");
        addPeopleback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPeoplebackActionPerformed(evt);
            }
        });

        jLabel33.setBackground(new java.awt.Color(102, 102, 255));
        jLabel33.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("افزودن شخص جدید");

        javax.swing.GroupLayout addPeoplePanelLayout = new javax.swing.GroupLayout(addPeoplePanel);
        addPeoplePanel.setLayout(addPeoplePanelLayout);
        addPeoplePanelLayout.setHorizontalGroup(
            addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPeoplePanelLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPeoplePanelLayout.createSequentialGroup()
                            .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addId)
                                .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPeoplePanelLayout.createSequentialGroup()
                            .addComponent(addPeopleback)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPeoplePanelLayout.createSequentialGroup()
                            .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addGroup(addPeoplePanelLayout.createSequentialGroup()
                                    .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(addcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(emailField)
                                            .addComponent(AddressField)
                                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(addPeoplePanelLayout.createSequentialGroup()
                                            .addComponent(partnerBtn)
                                            .addGap(18, 18, 18)
                                            .addComponent(clientBtn)
                                            .addGap(27, 27, 27)
                                            .addComponent(employeeBtn)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)))))
                            .addGap(13, 13, 13)))
                    .addGroup(addPeoplePanelLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel33)))
                .addGap(21, 21, 21))
        );
        addPeoplePanelLayout.setVerticalGroup(
            addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPeoplePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel33)
                .addGap(52, 52, 52)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partnerBtn)
                    .addComponent(clientBtn)
                    .addComponent(employeeBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPeoplePanelLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addPeoplePanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPeopleback, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        addCategoryPanel.setBackground(new java.awt.Color(153, 153, 153));
        addCategoryPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("عنوان دسته بندی را وارد کنید");

        confirmCategory.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        confirmCategory.setText("ثبت");
        confirmCategory.setPreferredSize(dimension);
        confirmCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmCategoryActionPerformed(evt);
            }
        });

        addback.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addback.setText("بازگشت به داشبورد اصلی");
        addback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbackActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("تلفن");

        jLabel41.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("نام");

        jLabel42.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("ایمیل");

        jLabel43.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("آدرس");

        jLabel44.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("کد ملی");

        jLabel34.setBackground(new java.awt.Color(102, 102, 255));
        jLabel34.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("افزودن دسته بنی جدید");

        javax.swing.GroupLayout addCategoryPanelLayout = new javax.swing.GroupLayout(addCategoryPanel);
        addCategoryPanel.setLayout(addCategoryPanelLayout);
        addCategoryPanelLayout.setHorizontalGroup(
            addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCategoryPanelLayout.createSequentialGroup()
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCategoryPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addCategoryPanelLayout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCategoryPanelLayout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCategoryPanelLayout.createSequentialGroup()
                                .addComponent(categoryFieldَAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCategoryPanelLayout.createSequentialGroup()
                                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(categoryFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addCategoryPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(addCategoryPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(addback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 114, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCategoryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(31, 31, 31))
        );
        addCategoryPanelLayout.setVerticalGroup(
            addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCategoryPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryFieldَAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addback, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        dashboard.setBackground(new java.awt.Color(102, 102, 102));

        dashboardBtnshowCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnshowCheck.setText("نمایش چک");
        dashboardBtnshowCheck.setPreferredSize(new java.awt.Dimension(103, 26));
        dashboardBtnshowCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnshowCheckActionPerformed(evt);
            }
        });

        addUserBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addUserBtn.setText("افزودن اشخاص");
        addUserBtn.setPreferredSize(new java.awt.Dimension(103, 26));
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        dashboardBtnshowDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnshowDoc.setText("نمایش سند");
        dashboardBtnshowDoc.setPreferredSize(new java.awt.Dimension(103, 26));
        dashboardBtnshowDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnshowDocActionPerformed(evt);
            }
        });

        dashboardBtnadd.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnadd.setText("افزودن چک");
        dashboardBtnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnaddActionPerformed(evt);
            }
        });

        dashboardBtnaddDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnaddDoc.setText("افزودن سند");
        dashboardBtnaddDoc.setPreferredSize(new java.awt.Dimension(103, 26));
        dashboardBtnaddDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnaddDocActionPerformed(evt);
            }
        });

        dashboardlabel.setBackground(new java.awt.Color(102, 102, 255));
        dashboardlabel.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardlabel.setForeground(new java.awt.Color(255, 255, 255));
        dashboardlabel.setText("داشبورد");

        tarazBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        tarazBtn.setText("نمودار تراز");
        tarazBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarazBtnActionPerformed(evt);
            }
        });

        backToLogin.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        backToLogin.setText("بازگشت به صفحه ورود");
        backToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToLoginActionPerformed(evt);
            }
        });

        dashboardBtnshowCheck1.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnshowCheck1.setText("تغییر وضعیت چک");
        dashboardBtnshowCheck1.setMaximumSize(new java.awt.Dimension(140, 109));
        dashboardBtnshowCheck1.setPreferredSize(new java.awt.Dimension(103, 26));
        dashboardBtnshowCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnshowCheck1ActionPerformed(evt);
            }
        });

        showPeople.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        showPeople.setText("نمایش اشخاص");
        showPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPeopleActionPerformed(evt);
            }
        });

        chartBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        chartBtn.setText("نمودار بدهکاری");
        chartBtn.setPreferredSize(new java.awt.Dimension(103, 26));
        chartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dashboardlabel)
                .addGap(41, 41, 41))
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backToLogin))
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dashboardBtnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dashboardBtnaddDoc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dashboardBtnshowCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dashboardBtnshowDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dashboardLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dashboardBtnshowCheck1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(dashboardLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tarazBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(dashboardlabel)
                .addGap(67, 67, 67)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarazBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dashboardBtnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardBtnshowCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardBtnshowCheck1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardBtnshowDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardBtnaddDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(backToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        showCheckpanel.setBackground(new java.awt.Color(153, 153, 153));
        showCheckpanel.setForeground(new java.awt.Color(255, 255, 255));

        payeeLabelCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        payeeLabelCheck.setForeground(new java.awt.Color(255, 255, 255));
        payeeLabelCheck.setText("طرف حساب");

        ShowChecksbtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        ShowChecksbtn.setText("نمایش چک ها");
        ShowChecksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowChecksbtnActionPerformed(evt);
            }
        });

        backshowDoc1.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowDoc1.setText("بازگشت به داشبورد اصلی");
        backshowDoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowDoc1ActionPerformed(evt);
            }
        });

        timeFilter.add(dailyCheckRBtn);
        dailyCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        dailyCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        dailyCheckRBtn.setText("روزانه");
        dailyCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyCheckRBtnActionPerformed(evt);
            }
        });

        timeFilter.add(weeklyCheckRBtn);
        weeklyCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        weeklyCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        weeklyCheckRBtn.setText("هفتگی");
        weeklyCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyCheckRBtnActionPerformed(evt);
            }
        });

        timeFilter.add(MonthlyCheckRBtn);
        MonthlyCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        MonthlyCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        MonthlyCheckRBtn.setText("ماهانه");
        MonthlyCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyCheckRBtnActionPerformed(evt);
            }
        });

        monthscheckCombo.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        monthscheckCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد ", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن ", "اسفند" }));
        monthscheckCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthscheckComboActionPerformed(evt);
            }
        });

        peopleCheckList.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        peopleCheckList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleCheckListActionPerformed(evt);
            }
        });

        costLabelCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        costLabelCheck.setForeground(new java.awt.Color(255, 255, 255));
        costLabelCheck.setText("مبلغ");

        filters.add(TimeCheckRBtn);
        TimeCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        TimeCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        TimeCheckRBtn.setText("فیلتر زمان");
        TimeCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeCheckRBtnActionPerformed(evt);
            }
        });

        filters.add(payeeCheckRBtn);
        payeeCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        payeeCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        payeeCheckRBtn.setText("طرف حساب");
        payeeCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payeeCheckRBtnActionPerformed(evt);
            }
        });

        filters.add(costCheckRBtn);
        costCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        costCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        costCheckRBtn.setText("فیلتر قیمت");
        costCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costCheckRBtnActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("فیلترها");

        jLabel24.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("بازه ی زمانی مورد نظر را وارد کنید");

        DRangeChecksYear.setBackground(new java.awt.Color(102, 102, 102));
        DRangeChecksYear.setForeground(new java.awt.Color(255, 255, 255));
        DRangeChecksYear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        DRangeChecksMonth.setBackground(new java.awt.Color(102, 102, 102));
        DRangeChecksMonth.setForeground(new java.awt.Color(255, 255, 255));
        DRangeChecksMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel5.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("نمایش چک ها");

        DRangeDocsYear2.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsYear2.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsYear2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        DRangeDocsMonth2.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsMonth2.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsMonth2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel28.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("از تاریخ");

        jLabel35.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("تا تاریخ");

        DRangeChecksYear1.setBackground(new java.awt.Color(102, 102, 102));
        DRangeChecksYear1.setForeground(new java.awt.Color(255, 255, 255));
        DRangeChecksYear1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        DRangeChecksYear1.setCaretColor(new java.awt.Color(255, 255, 255));

        DRangeDocsDay3.setBackground(new java.awt.Color(102, 102, 102));
        DRangeDocsDay3.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsDay3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("/");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("/");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("/");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("/");

        checkSlider1.setBackground(new java.awt.Color(255, 255, 255));
        checkSlider1.setForeground(new java.awt.Color(0, 51, 255));

        checkSlider2.setBackground(new java.awt.Color(255, 255, 255));
        checkSlider2.setForeground(new java.awt.Color(0, 51, 255));

        checkCostFrom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkCostFrom.setForeground(new java.awt.Color(255, 255, 255));
        checkCostFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "از", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        checkCostTo.setForeground(new java.awt.Color(255, 255, 255));
        checkCostTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "تا", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        filteringChecks.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        filteringChecks.setText("اعمال فیلتر");
        filteringChecks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filteringChecksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showCheckpanelLayout = new javax.swing.GroupLayout(showCheckpanel);
        showCheckpanel.setLayout(showCheckpanelLayout);
        showCheckpanelLayout.setHorizontalGroup(
            showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCheckpanelLayout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel28))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(showCheckpanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderCheckLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DRangeChecksYear, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeDocsYear2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel47))
                        .addGap(11, 11, 11)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addComponent(DRangeDocsMonth2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DRangeDocsDay3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addComponent(DRangeChecksMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DRangeChecksYear1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(showCheckpanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkCostTo, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(checkCostFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(costLabelCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payeeLabelCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peopleCheckList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(showCheckpanelLayout.createSequentialGroup()
                                    .addComponent(monthscheckCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(355, 355, 355)
                                    .addComponent(costCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                                    .addComponent(MonthlyCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(weeklyCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46)
                                    .addComponent(dailyCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TimeCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addGap(513, 513, 513)
                                .addComponent(payeeCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))))
            .addGroup(showCheckpanelLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(backshowDoc1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShowChecksbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filteringChecks)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showCheckpanelLayout.setVerticalGroup(
            showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCheckpanelLayout.createSequentialGroup()
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(payeeCheckRBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TimeCheckRBtn)
                                    .addComponent(dailyCheckRBtn)
                                    .addComponent(weeklyCheckRBtn)
                                    .addComponent(MonthlyCheckRBtn)))
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costCheckRBtn))
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(monthscheckCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(payeeLabelCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(peopleCheckList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                                        .addComponent(checkSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                                        .addComponent(costLabelCheck)
                                        .addGap(29, 29, 29)))
                                .addComponent(checkSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addComponent(checkCostFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkCostTo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(sliderCheckLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DRangeChecksYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeChecksMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeChecksYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DRangeDocsYear2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeDocsMonth2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeDocsDay3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47))
                        .addGap(43, 43, 43)))
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowChecksbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backshowDoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filteringChecks, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        checksReport.setBackground(new java.awt.Color(153, 153, 153));
        checksReport.setFont(new java.awt.Font("B Roya", 0, 14)); // NOI18N
        checksReport.setPreferredSize(new java.awt.Dimension(455, 444));

        checksTable.setFont(new java.awt.Font("B Nazanin", 1, 14)); // NOI18N
        checksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "طرف حساب", "بدهکار", "بستانکار", "تاریخ", "مبلغ"
            }
        ));
        jScrollPane3.setViewportView(checksTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("نمایش چک ها");

        backshowCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck.setText("بازگشت به داشبورد ");
        backshowCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheckActionPerformed(evt);
            }
        });

        checkWeightLabel.setBorder(javax.swing.BorderFactory.createTitledBorder("راس چک"));

        javax.swing.GroupLayout checksReportLayout = new javax.swing.GroupLayout(checksReport);
        checksReport.setLayout(checksReportLayout);
        checksReportLayout.setHorizontalGroup(
            checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checksReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checksReportLayout.createSequentialGroup()
                        .addGap(0, 583, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(checksReportLayout.createSequentialGroup()
                        .addComponent(backshowCheck)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(checksReportLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(checkWeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        checksReportLayout.setVerticalGroup(
            checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checksReportLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkWeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(backshowCheck)
                .addContainerGap())
        );

        docsReport.setBackground(new java.awt.Color(102, 102, 102));
        docsReport.setPreferredSize(new java.awt.Dimension(455, 444));

        docsTable.setFont(new java.awt.Font("B Nazanin", 1, 12)); // NOI18N
        docsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "طرف حساب", "بدهکار", "بستانکار", "تاریخ", "مبلغ", "توضیحات"
            }
        ));
        docsTable.setToolTipText("");
        jScrollPane4.setViewportView(docsTable);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نمایش سند ها");

        backshowCheck1.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck1.setText("بازگشت به داشبورد ");
        backshowCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout docsReportLayout = new javax.swing.GroupLayout(docsReport);
        docsReport.setLayout(docsReportLayout);
        docsReportLayout.setHorizontalGroup(
            docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docsReportLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(docsReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addGroup(docsReportLayout.createSequentialGroup()
                        .addComponent(backshowCheck1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        docsReportLayout.setVerticalGroup(
            docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docsReportLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backshowCheck1)
                .addContainerGap())
        );

        peopleReports.setBackground(new java.awt.Color(102, 102, 102));

        peopleTable.setFont(new java.awt.Font("B Nazanin", 1, 14)); // NOI18N
        peopleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "نام شخص", "کد ملی", "گروه", "آدرس", "تلفن", "ایمیل"
            }
        ));
        peopleTable.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(peopleTable);

        jLabel52.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("لیست اشخاص");

        backshowCheck2.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck2.setText("بازگشت به داشبورد ");
        backshowCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout peopleReportsLayout = new javax.swing.GroupLayout(peopleReports);
        peopleReports.setLayout(peopleReportsLayout);
        peopleReportsLayout.setHorizontalGroup(
            peopleReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(peopleReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(peopleReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(peopleReportsLayout.createSequentialGroup()
                        .addComponent(backshowCheck2)
                        .addGap(0, 434, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, peopleReportsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel52)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        peopleReportsLayout.setVerticalGroup(
            peopleReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, peopleReportsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(backshowCheck2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "طرف حساب", "بدهکار", "بستانکار", "تاریخ"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        backshowCheck3.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck3.setText("بازگشت به داشبورد ");
        backshowCheck3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tarazNameLayout = new javax.swing.GroupLayout(tarazName);
        tarazName.setLayout(tarazNameLayout);
        tarazNameLayout.setHorizontalGroup(
            tarazNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tarazNameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tarazNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addGroup(tarazNameLayout.createSequentialGroup()
                        .addComponent(backshowCheck3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tarazNameLayout.setVerticalGroup(
            tarazNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tarazNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(backshowCheck3)
                .addContainerGap())
        );

        backshowCheck4.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck4.setText("بازگشت به داشبورد ");
        backshowCheck4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chartLayout = new javax.swing.GroupLayout(chart);
        chart.setLayout(chartLayout);
        chartLayout.setHorizontalGroup(
            chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backshowCheck4)
                .addContainerGap(483, Short.MAX_VALUE))
        );
        chartLayout.setVerticalGroup(
            chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chartLayout.createSequentialGroup()
                .addContainerGap(551, Short.MAX_VALUE)
                .addComponent(backshowCheck4)
                .addContainerGap())
        );

        filteredDocs.setBackground(new java.awt.Color(102, 102, 102));

        filteredDocTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "طرف حساب", "ارزش معامله", "وضعیت", "تاریخ ثبت", "زمان ثبت", "توضیحات"
            }
        ));
        jScrollPane5.setViewportView(filteredDocTable);

        jLabel59.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("نمایش سند های فیلتر شده");

        backshowCheck5.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck5.setText("بازگشت به داشبورد ");
        backshowCheck5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filteredDocsLayout = new javax.swing.GroupLayout(filteredDocs);
        filteredDocs.setLayout(filteredDocsLayout);
        filteredDocsLayout.setHorizontalGroup(
            filteredDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
            .addGroup(filteredDocsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backshowCheck5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredDocsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel59)
                .addGap(23, 23, 23))
        );
        filteredDocsLayout.setVerticalGroup(
            filteredDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredDocsLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backshowCheck5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        filteredChecks.setBackground(new java.awt.Color(102, 102, 102));

        filteredCheckTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "طرف حساب", "ارزش معامله", "وضعیت", "تاریخ پاس", "زمان ثبت", "توضیحات"
            }
        ));
        jScrollPane6.setViewportView(filteredCheckTable);

        jLabel58.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("نمایش چک های فیلتر شده");

        backshowCheck6.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck6.setText("بازگشت به داشبورد ");
        backshowCheck6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filteredChecksLayout = new javax.swing.GroupLayout(filteredChecks);
        filteredChecks.setLayout(filteredChecksLayout);
        filteredChecksLayout.setHorizontalGroup(
            filteredChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredChecksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel58)
                .addContainerGap())
            .addGroup(filteredChecksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backshowCheck6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filteredChecksLayout.setVerticalGroup(
            filteredChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredChecksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(backshowCheck6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 39, Short.MAX_VALUE)
                    .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 39, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(addcheckPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 12, Short.MAX_VALUE)
                    .addComponent(stateChangePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(showDocPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(addDocPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 85, Short.MAX_VALUE)
                    .addComponent(addPeoplePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 85, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 91, Short.MAX_VALUE)
                    .addComponent(addCategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 92, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(showCheckpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 162, Short.MAX_VALUE)
                    .addComponent(checksReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 163, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 162, Short.MAX_VALUE)
                    .addComponent(docsReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 163, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 90, Short.MAX_VALUE)
                    .addComponent(peopleReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 90, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(69, Short.MAX_VALUE)
                    .addComponent(tarazName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 68, Short.MAX_VALUE)
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 69, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filteredDocs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filteredChecks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 94, Short.MAX_VALUE)
                    .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 93, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(addcheckPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 64, Short.MAX_VALUE)
                    .addComponent(stateChangePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 64, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(showDocPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(addDocPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 82, Short.MAX_VALUE)
                    .addComponent(addPeoplePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 81, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 98, Short.MAX_VALUE)
                    .addComponent(addCategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 98, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(showCheckpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 156, Short.MAX_VALUE)
                    .addComponent(checksReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 155, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 156, Short.MAX_VALUE)
                    .addComponent(docsReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 155, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 84, Short.MAX_VALUE)
                    .addComponent(peopleReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 84, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(tarazName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 86, Short.MAX_VALUE)
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 86, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filteredDocs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filteredChecks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("frameCheck");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void addcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcategoryActionPerformed

        landPage(addCategoryPanel);

    }//GEN-LAST:event_addcategoryActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void checkIdentifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkIdentifierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkIdentifierActionPerformed

    private void TimeCheckAddDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeCheckAddDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeCheckAddDayActionPerformed

    private void payeeCostAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payeeCostAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payeeCostAddActionPerformed

    private void emailfieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailfieldLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailfieldLoginActionPerformed

    private void enterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBtnActionPerformed

        System.out.println(emailfieldLogin.getText());
        loginLogic = new LoginLogic();
        if (loginLogic.canEnter(emailfieldLogin.getText(), passwordField.getText())) {
            landPage(dashboard);
        }

        //  enterBtn.setBackground(Color.red);
        //}
    }//GEN-LAST:event_enterBtnActionPerformed

    private void backCheckStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backCheckStateActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backCheckStateActionPerformed

    private void addDocbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocbackActionPerformed
        landPage(dashboard);
//        addDocPanel.setVisible(false);
        //       dashboard.setVisible(true);
    }//GEN-LAST:event_addDocbackActionPerformed

    private void addbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbackActionPerformed
        landPage(dashboard);
        //    addCategoryPanel.setVisible(false);
        //    dashboard.setVisible(true);
    }//GEN-LAST:event_addbackActionPerformed

    private void addPeoplebackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPeoplebackActionPerformed
        landPage(dashboard);
        //    addPeoplePanel.setVisible(false);
        //   dashboard.setVisible(true);
    }//GEN-LAST:event_addPeoplebackActionPerformed

    private void addCheckBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCheckBackActionPerformed
        //   addcheckPanel.setVisible(false);
        //   dashboard.setVisible(true);
        landPage(dashboard);
    }//GEN-LAST:event_addCheckBackActionPerformed

    private void confirmCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmCategoryActionPerformed
        AddUserLogic addUser = new AddUserLogic();
        String newCat = categoryField.getText();
        GroupType newCategory = new GroupType(newCat);
        String emailfieldCategory = emailField.getText();
        String addressFieldUser = AddressField.getText();
        String userNameCategory = addName.getText();
        String internationalIdCategory = addId.getText();
        String phoneCategory = phoneField.getText();

        if (addUserLogic.canSubmitPeople(userNameCategory, phoneCategory, internationalIdCategory, addressFieldUser, emailfieldCategory)) {
            Manager.addCostumer(new Costumer(userNameCategory,
                    internationalIdCategory, newCategory, addressFieldUser,
                    phoneCategory, emailfieldCategory));
        }

        peopleDocList.addItem(categoryFieldName.getText());   //fix this


    }//GEN-LAST:event_confirmCategoryActionPerformed

    private void registerCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerCheckActionPerformed

        int indexCostumer = payeesComboBox.getSelectedIndex();
        System.out.println(indexCostumer);
        boolean checkCashed = isCashedBtn.isSelected();
        String selected1 = payeesComboBox.getSelectedItem().toString();
        System.out.println(selected1);
        String descriptionDoc = discriptionTextAdd.getText();
        String costDoc = payeeCostAdd.getText();
        int checkDay = Integer.parseInt(TimeCheckAddDay.getText());
        int checkMonth = Integer.parseInt(TimeCheckAddMonth.getText());
        int checkYear = Integer.parseInt(TimeCheckAddYear.getText());
        if (addCheckLogic.canSubmitCheck(selected1, costDoc, descriptionDoc)) {
            Manager.addCheckDocument(new CheckDoc(costDoc,
                    descriptionDoc,
                    new DateNizek(checkDay, checkMonth, checkYear),
                    new TimeNizek(), checkCashed,
                    userRepository.findCostumerBasedOnIndex(indexCostumer)));
        } else {
            JOptionPane.showMessageDialog(addDocPanel, "فیلد های چک را صحیح وارد کنید",
                    "اطلاعات نامعتبر", JOptionPane.ERROR_MESSAGE);

        }
        checkSlider1.setMaximum((int)userRepository.getMaxCheckDoc());//add check add doc
        checkSlider2.setMaximum((int)userRepository.getMaxCheckDoc());

    }//GEN-LAST:event_registerCheckActionPerformed

    private void registerChangeCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerChangeCheckActionPerformed

        for (CheckDoc check : Manager.checkDocList) {
            if (check.getPayee().equals(changeStateComboBox.getSelectedItem().toString()) && Integer.toString(check.getIdentifier()).equals(checkIdentifier.getText())) {
                check.isCashed = isCreditorToggle.isSelected();
            }
        }

    }//GEN-LAST:event_registerChangeCheckActionPerformed

    private void backshowCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowCheck1ActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowCheck1ActionPerformed

    private void backshowCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowCheckActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowCheckActionPerformed

    private void submitDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitDocActionPerformed
        int indexCostumerDoc = addDocCombo.getSelectedIndex();
        boolean DocIsCreditor = creditorBtn.isSelected();

        int docDayValue = Integer.parseInt(docDay.getText());
        int docMonthValue = Integer.parseInt(docMonth.getText());
        int docYearValue = Integer.parseInt(docYear.getText());

        System.out.println(indexCostumerDoc);
        String selectedDoc = addDocCombo.getSelectedItem().toString();
        System.out.println(selectedDoc);

        String descriptionDoc = discriptionTextAdd.getText();
        String addCostDoc = costDocAdd.getText();
        String addDocSelectedPayee = addDocCombo.getSelectedItem().toString();

        if (addDocLogic.canSubmitDoc(selectedDoc, addCostDoc, descriptionDoc)) {
            Manager.addNormalDocument(new NormalDoc(
                    addCostDoc,
                    descriptionDoc,
                    DocIsCreditor,
                    new DateNizek(docDayValue, docMonthValue, docYearValue),
                    new TimeNizek(),
                    userRepository.findCostumerBasedOnIndex(indexCostumerDoc)));
        } else {
            JOptionPane.showMessageDialog(addDocPanel, "فیلد های  سند را صحیح وارد کنید",
                    "اطلاعات نامعتبر", JOptionPane.ERROR_MESSAGE);

        }

        docSlider1.setMaximum((int)userRepository.getMaxNormalDoc());//add check add doc
        docSlider2.setMaximum((int)userRepository.getMaxNormalDoc());
        
    }//GEN-LAST:event_submitDocActionPerformed

    private void btnconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmActionPerformed
        String category = "";
        String emailfieldUser = emailField.getText();
        String addressfieldUser = AddressField.getText();
        String userName = addName.getText();
        String nationalId = addId.getText();
        String phone = phoneField.getText();
        if (employeeBtn.isSelected()) {
            category = "کارمند";
        } else if (partnerBtn.isSelected()) {
            category = "شریک تجاری";
        } else if (clientBtn.isSelected()) {
            category = "مشتری";
        }
        GroupType type = new GroupType(category);
        if (addUserLogic.canSubmitPeople(userName, phone, nationalId, addressfieldUser, emailfieldUser)) {
            Costumer costumer = new Costumer(userName,
                    nationalId, type, addressfieldUser,
                    phone,
                    emailfieldUser);
            Manager.addCostumer(costumer);

            //exchange this with the new method
//     addUserLogic.passUserTodataBase(userId, userName, phone, addressfieldUser, type);
        } else {
            JOptionPane.showMessageDialog(addDocPanel, "فیلد  های ورودی را صحیح وارد کنید",
                    "اطلاعات نامعتبر", JOptionPane.ERROR_MESSAGE);
        }

        peopleDocList.addItem(userName);
        payeesComboBox.addItem(userName);
        addDocCombo.addItem(userName);
        peopleCheckList.addItem(userName);
        changeStateComboBox.addItem(userName);
    }//GEN-LAST:event_btnconfirmActionPerformed

    private void employeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeBtnActionPerformed
        employeeBtn.isSelected();
    }//GEN-LAST:event_employeeBtnActionPerformed

    private void clientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientBtnActionPerformed
        clientBtn.isSelected();
    }//GEN-LAST:event_clientBtnActionPerformed

    private void partnerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partnerBtnActionPerformed
        partnerBtn.isSelected();
    }//GEN-LAST:event_partnerBtnActionPerformed

    private void costCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costCheckRBtnActionPerformed
        filterVisibelity(costCheckRBtn);
    }//GEN-LAST:event_costCheckRBtnActionPerformed

    private void payeeCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payeeCheckRBtnActionPerformed
        filterVisibelity(payeeCheckRBtn);
    }//GEN-LAST:event_payeeCheckRBtnActionPerformed

    private void TimeCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeCheckRBtnActionPerformed
        filterVisibelity(TimeCheckRBtn);
    }//GEN-LAST:event_TimeCheckRBtnActionPerformed

    private void peopleCheckListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleCheckListActionPerformed

    }//GEN-LAST:event_peopleCheckListActionPerformed

    private void monthscheckComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthscheckComboActionPerformed
     DRangeChecksMonth.setText(Integer.toString(monthscheckCombo.getSelectedIndex()+1));
        DRangeDocsMonth2.setText(Integer.toString(monthscheckCombo.getSelectedIndex()+1));
    }//GEN-LAST:event_monthscheckComboActionPerformed

    private void MonthlyCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthlyCheckRBtnActionPerformed
        filterVisibelity(MonthlyCheckRBtn);
        
        
    }//GEN-LAST:event_MonthlyCheckRBtnActionPerformed

    private void weeklyCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyCheckRBtnActionPerformed
        weeklyCheckRBtn.isSelected();
    }//GEN-LAST:event_weeklyCheckRBtnActionPerformed

    private void dailyCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyCheckRBtnActionPerformed
        dailyCheckRBtn.isSelected();
    }//GEN-LAST:event_dailyCheckRBtnActionPerformed

    private void backshowDoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowDoc1ActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowDoc1ActionPerformed

    private void ShowChecksbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowChecksbtnActionPerformed
        landPage(checksReport);
        Double weight = Accounting.calculateWeight();
        checkWeightLabel.setText(String.valueOf(weight));

        int selectedMonth = monthscheckCombo.getSelectedIndex();//the month
        if (costCheckRBtn.isSelected()) {
            int checkCostFromValue = checkSlider1.getValue();
            int checkcostToValue = checkSlider2.getValue();
            if (checkCostFromValue > checkcostToValue) {
                int temp = checkCostFromValue;
                checkCostFromValue = checkcostToValue;
                checkcostToValue = temp;

                checkCostFrom.setText(Integer.toString(checkCostFromValue));
                checkCostTo.setText(Integer.toString(checkcostToValue));

                checkSlider1.setValue(checkCostFromValue);
                checkSlider2.setValue(checkcostToValue);

            }

        } else if (TimeCheckRBtn.isSelected()) {
            if (MonthlyCheckRBtn.isSelected()) {
                String CheckfilterDfrom = DRangeChecksYear.getText();
            } else {
                String CheckfilterMfrom = DRangeChecksMonth.getText();
                String CheckfilterYfrom = DRangeChecksYear1.getText();

                String CheckfilterDTo = DRangeDocsDay3.getText();
                String CheckfilterMTo = DRangeDocsMonth2.getText();
                String CheckfilterYTo = DRangeDocsYear2.getText();
            }
        }

    }//GEN-LAST:event_ShowChecksbtnActionPerformed

    private void groupDocSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupDocSubmitActionPerformed

        addDocCounter++;
        countDoc.setText(String.valueOf(addDocCounter));
    }//GEN-LAST:event_groupDocSubmitActionPerformed

    private void addCheckBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCheckBack1ActionPerformed
        addCheckCounter++;
        countCheck.setText(String.valueOf(addCheckCounter));

    }//GEN-LAST:event_addCheckBack1ActionPerformed

    private void passWordRecoveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passWordRecoveryActionPerformed
        JOptionPane.showMessageDialog(addDocPanel, "مشکل خودتان است",
                "", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_passWordRecoveryActionPerformed

    private void backshowCheck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowCheck2ActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowCheck2ActionPerformed

    private void payeesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payeesComboBoxActionPerformed

    }//GEN-LAST:event_payeesComboBoxActionPerformed

    private void TimeCheckAddYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeCheckAddYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeCheckAddYearActionPerformed

    private void TimeCheckAddMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeCheckAddMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeCheckAddMonthActionPerformed

    private void isCreditorToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isCreditorToggleActionPerformed

    }//GEN-LAST:event_isCreditorToggleActionPerformed

    private void backshowCheck3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowCheck3ActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowCheck3ActionPerformed

    private void backshowCheck4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowCheck4ActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowCheck4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        landPage(addPeoplePanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        landPage(addPeoplePanel);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void costDocRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costDocRBtnActionPerformed
        filterVisibelity(costDocRBtn);
    }//GEN-LAST:event_costDocRBtnActionPerformed

    private void payeeDocRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payeeDocRBtnActionPerformed
        filterVisibelity(payeeDocRBtn);
    }//GEN-LAST:event_payeeDocRBtnActionPerformed

    private void TimeDocRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeDocRBtnActionPerformed
        filterVisibelity(TimeDocRBtn);
    }//GEN-LAST:event_TimeDocRBtnActionPerformed

    private void peopleDocListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peopleDocListActionPerformed

    }//GEN-LAST:event_peopleDocListActionPerformed

    private void monthsDocComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthsDocComboActionPerformed
        DRangeDocsMonthFrom.setText(Integer.toString(monthsDocCombo.getSelectedIndex()+1));
        DRangeDocsmonthTo.setText(Integer.toString(monthsDocCombo.getSelectedIndex()+1));
    }//GEN-LAST:event_monthsDocComboActionPerformed

    private void MonthlyDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthlyDocActionPerformed
        filterVisibelity(MonthlyDoc);
    }//GEN-LAST:event_MonthlyDocActionPerformed

    private void dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyActionPerformed

    }//GEN-LAST:event_dailyActionPerformed

    private void backshowDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowDocActionPerformed

        landPage(dashboard);
    }//GEN-LAST:event_backshowDocActionPerformed

    private void ShowDocsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowDocsbtnActionPerformed
        landPage(docsReport);
        if (costDocRBtn.isSelected()) {
            int DocCostFromValue = docSlider1.getValue();
            int DocCostToValue = docSlider2.getValue();
            System.out.println("DocCostFromValue" + DocCostFromValue);
            System.out.println("DocCostTOValue" + DocCostToValue);

            if (DocCostFromValue > DocCostToValue) {
                int temp = DocCostFromValue;
                DocCostFromValue = DocCostToValue;
                DocCostToValue = temp;

                DocCostFrom.setText(Integer.toString(DocCostFromValue));
                DocCostTo.setText(Integer.toString(DocCostToValue));

                docSlider1.setValue(DocCostFromValue);
                docSlider2.setValue(DocCostToValue);

            }
        }
        if (TimeDocRBtn.isSelected()) {
            if (MonthlyDoc.isSelected()) {
                int selectedMonth1 = monthsDocCombo.getSelectedIndex();
            } else {
                String filterDfrom = DRangeDocsDayFrom.getText();
                String filterMfrom = DRangeDocsMonthFrom.getText();
                String filterYfrom = DRangeDocsYearFrom.getText();

                String filterDTo = DRangeDocsDayTo.getText();
                String filterMTo = DRangeDocsmonthTo.getText();
                String filterYTo = DRangeDocsYearTo.getText();
            
            }
        }
    }//GEN-LAST:event_ShowDocsbtnActionPerformed

    private void chartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartBtnActionPerformed
        landPage(chart);
    }//GEN-LAST:event_chartBtnActionPerformed

    private void showPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPeopleActionPerformed
        landPage(peopleReports);
    }//GEN-LAST:event_showPeopleActionPerformed

    private void dashboardBtnshowCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnshowCheck1ActionPerformed
        landPage(stateChangePanel);
    }//GEN-LAST:event_dashboardBtnshowCheck1ActionPerformed

    private void backToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToLoginActionPerformed
        landPage(LoginPanel);
    }//GEN-LAST:event_backToLoginActionPerformed

    private void tarazBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarazBtnActionPerformed
        landPage(tarazName);
    }//GEN-LAST:event_tarazBtnActionPerformed

    private void dashboardBtnaddDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnaddDocActionPerformed

        landPage(addDocPanel);
        //   landPage(addingDocPanel);
        //        addDocPanel.setVisible(true);
        //      dashboard.setVisible(false);
    }//GEN-LAST:event_dashboardBtnaddDocActionPerformed

    private void dashboardBtnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnaddActionPerformed
        landPage(addcheckPanel);
    }//GEN-LAST:event_dashboardBtnaddActionPerformed

    private void dashboardBtnshowDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnshowDocActionPerformed
        landPage(showDocPanel);

        //showDOcPanel.setVisible(true);
        //dashboard.setVisible(false);
    }//GEN-LAST:event_dashboardBtnshowDocActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        landPage(addPeoplePanel);
        //        addPeoplePanel.setVisible(true);
        //        dashboard.setVisible(false);
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void dashboardBtnshowCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardBtnshowCheckActionPerformed
        landPage(showCheckpanel);


    }//GEN-LAST:event_dashboardBtnshowCheckActionPerformed

    private void costDocAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costDocAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costDocAddActionPerformed

    private void docMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docMonthActionPerformed

    private void backshowCheck5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowCheck5ActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowCheck5ActionPerformed

    private void backshowCheck6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowCheck6ActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowCheck6ActionPerformed

    private void filteringChecksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filteringChecksActionPerformed
        checkFilter = filterSelector();

        int selectedMonth = monthscheckCombo.getSelectedIndex();//the month
        //============ slider cost==================================================
        if (costCheckRBtn.isSelected()) {
            int checkCostFromValue = checkSlider1.getValue();
            int checkcostToValue = checkSlider2.getValue();
            if (checkCostFromValue > checkcostToValue) {
                int temp = checkCostFromValue;
                checkCostFromValue = checkcostToValue;
                checkcostToValue = temp;
            }

            checkCostFrom.setText(Double.toString(checkCostFromValue));
            checkCostTo.setText(Double.toString(checkcostToValue));

            checkSlider1.setValue(checkCostFromValue);
            checkSlider2.setValue(checkcostToValue);
            //  checkWeightLabel.setText(String.valueOf(Accounting.calculateWeight()));
            filterChecks = new FilterChecks(checkFilter, checkCostFromValue, checkcostToValue);
        } else if (TimeCheckRBtn.isSelected()) {
            int CheckfilterDfrom = Integer.parseInt(DRangeChecksYear1.getText());//integer 
            int CheckfilterMfrom = Integer.parseInt(DRangeChecksMonth.getText());
            int CheckfilterYfrom = Integer.parseInt(DRangeChecksYear.getText());
            DateNizek dateNZKFrom = new DateNizek(CheckfilterDfrom, CheckfilterMfrom, CheckfilterYfrom);

            int CheckfilterDTo = Integer.parseInt(DRangeDocsDay3.getText());
            int CheckfilterMTo = Integer.parseInt(DRangeDocsMonth2.getText());
            int CheckfilterYTo = Integer.parseInt(DRangeDocsYear2.getText());

            DateNizek dateNZKTo = new DateNizek(CheckfilterDTo, CheckfilterMTo, CheckfilterYTo);

            filterChecks = new FilterChecks(checkFilter, dateNZKTo, dateNZKFrom);
        } else if (payeeCheckRBtn.isSelected()) {

            String payeeFilterNameCheck = peopleCheckList.getSelectedItem().toString();

            filterChecks = new FilterChecks(checkFilter, payeeFilterNameCheck);

        }

        filteredCheckTable.setModel(filterChecks);

        landPage(filteredChecks);
    }//GEN-LAST:event_filteringChecksActionPerformed

    private void filteringDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filteringDocsActionPerformed
        docFilter = filterDocSelector();

        if (costDocRBtn.isSelected()) {
            int docCostFromValue = docSlider1.getValue();
            int docCostToValue = docSlider2.getValue();
            if (docCostFromValue > docCostToValue) {
                int temp = docCostFromValue;
                docCostFromValue = docCostToValue;
                docCostToValue = temp;
            }

            DocCostFrom.setText(Integer.toString(docCostFromValue));
            DocCostTo.setText(Integer.toString(docCostToValue));

            docSlider1.setValue(docCostFromValue);
            docSlider2.setValue(docCostToValue);
            //  checkWeightLabel.setText(String.valueOf(Accounting.calculateWeight()));
            filterDocs = new FilterDocs(docFilter, docCostFromValue, docCostToValue);
        } else if (TimeDocRBtn.isSelected()) {
//===================================================================================================================            
            int DocfilterDfrom = Integer.parseInt(DRangeDocsDayFrom.getText());//integer 
            int DocfilterMfrom = Integer.parseInt(DRangeDocsMonthFrom.getText());
            int DocfilterYfrom = Integer.parseInt(DRangeDocsYearFrom.getText());
            DateNizek dateNZKFrom = new DateNizek(DocfilterDfrom, DocfilterMfrom, DocfilterYfrom);
boolean validFrom=(Validator.dayFieldIsValid(DRangeDocsDayFrom.getText())
        &&Validator.monthIsValid(DRangeDocsMonthFrom.getText())&&
        Validator.yearIsValidDoc(DRangeDocsYearFrom.getText()));
//==================================================================================================================            
            int DocfilterDTo = Integer.parseInt(DRangeDocsDayTo.getText());
            int DocfilterMTo = Integer.parseInt(DRangeDocsmonthTo.getText());
            int DocfilterYTo = Integer.parseInt(DRangeDocsYearTo.getText());
            DateNizek dateNZKTo = new DateNizek(DocfilterDTo, DocfilterMTo, DocfilterYTo);
   
boolean validTo=(Validator.dayFieldIsValid(DRangeDocsDayTo.getText())
        &&Validator.monthIsValid(DRangeDocsmonthTo.getText())&&
        Validator.yearIsValidDoc(DRangeDocsYearTo.getText()));
            filterDocs = new FilterDocs(docFilter, dateNZKTo, dateNZKFrom);
if(!(validTo&&validFrom)){
  JOptionPane.showMessageDialog(addDocPanel, "فیلد های تاریخ را صحیح وارد کنید",
                "", JOptionPane.ERROR_MESSAGE);

landPage(showDocPanel);
}
        
        
        } else if (payeeDocRBtn.isSelected()) {

            String payeeFilterNameCheck = peopleDocList.getSelectedItem().toString();

            filterDocs = new FilterDocs(docFilter, payeeFilterNameCheck);

        }

        filteredDocTable.setModel(filterDocs);
        landPage(filteredDocs);

//    checkWeightLabel.setText(String.valueOf(Accounting.calculateWeight()));
    }//GEN-LAST:event_filteringDocsActionPerformed

    private void DRangeDocsmonthToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DRangeDocsmonthToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DRangeDocsmonthToActionPerformed

    private void DRangeDocsDayFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DRangeDocsDayFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DRangeDocsDayFromActionPerformed

    private void convertToDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertToDocActionPerformed
        for (CheckDoc check : Manager.checkDocList) {
            if (Integer.toString(check.getIdentifier()).equals(checkIdentifier.getText())) {
                NormalDoc newDoc = new NormalDoc(check.getCost(), check.getDescription(), false, check.getDate(), check.getTimeNizek(), check.getCostumer());
                Manager.normalDocList.add(newDoc);
            }
    }//GEN-LAST:event_convertToDocActionPerformed
    }

    public void filterVisibelity(JRadioButton Rbtn) {
filteringDocs.setEnabled(payeeDocRBtn.isSelected()||TimeDocRBtn.isSelected()||costDocRBtn.isSelected());
filteringChecks.setEnabled(payeeCheckRBtn.isSelected()||TimeCheckRBtn.isSelected()||costCheckRBtn.isSelected());
        docSlider2.setEnabled(costDocRBtn.isSelected());
        docSlider1.setEnabled(costDocRBtn.isSelected());
        checkSlider2.setEnabled(costCheckRBtn.isSelected());
        checkSlider1.setEnabled(costCheckRBtn.isSelected());
        peopleCheckList.setEnabled(payeeCheckRBtn.isSelected());
        monthscheckCombo.setEnabled(MonthlyCheckRBtn.isSelected());
        costLabelCheck.setEnabled(costCheckRBtn.isSelected());
        payeeLabelCheck.setEnabled(payeeCheckRBtn.isSelected());
        weeklyCheckRBtn.setEnabled(TimeCheckRBtn.isSelected());
        dailyCheckRBtn.setEnabled(TimeCheckRBtn.isSelected());
        MonthlyCheckRBtn.setEnabled(TimeCheckRBtn.isSelected());
        //======docs visiblity=========================
        payeeLabel.setEnabled(payeeDocRBtn.isSelected());
        costLabel.setEnabled(costDocRBtn.isSelected());
        peopleDocList.setEnabled(payeeDocRBtn.isSelected());
        // checkSlider2.setEnabled(costDocRBtn.isSelected());
        daily.setEnabled(TimeDocRBtn.isSelected());
        weeklyDoc.setEnabled(TimeDocRBtn.isSelected());
        MonthlyDoc.setEnabled(TimeDocRBtn.isSelected());
        monthsDocCombo.setEnabled(MonthlyDoc.isSelected());
        // monthsDocList.setEnabled(MonthlyDoc.isSelected() && TimeCheckRBtn.isSelected());
        //  monthscheckList.setEnabled(TimeCheckRBtn.isSelected());
        //==============conflict of monthComboBox enablity ========================
        if (payeeDocRBtn.isSelected() || costDocRBtn.isSelected()) {
            monthsDocCombo.setEnabled(false);
        }
        if (payeeCheckRBtn.isSelected() || costCheckRBtn.isSelected()) {
            monthscheckCombo.setEnabled(false);

        }
    }

    public void disableFilter() {
filteringDocs.setEnabled(payeeDocRBtn.isSelected()||TimeDocRBtn.isSelected()||costDocRBtn.isSelected());
filteringChecks.setEnabled(payeeCheckRBtn.isSelected()||TimeCheckRBtn.isSelected()||costCheckRBtn.isSelected());
        monthsDocCombo.setEnabled(TimeDocRBtn.isSelected() && MonthlyDoc.isSelected());
        weeklyCheckRBtn.setEnabled(false);
        dailyCheckRBtn.setEnabled(false);
        MonthlyCheckRBtn.setEnabled(false);
        monthscheckCombo.setEnabled(false);
        daily.setEnabled(false);
        weeklyDoc.setEnabled(false);
        MonthlyDoc.setEnabled(false);
        peopleDocList.setEnabled(false);
        checkSlider1.setEnabled(false);
        checkSlider2.setEnabled(false);
        docSlider1.setEnabled(false);
        docSlider2.setEnabled(false);
        peopleCheckList.setEnabled(false);
        

    }

    public void landPage(JPanel panel) {

        filteredDocs.setVisible(panel == filteredDocs);
        filteredChecks.setVisible(panel == filteredChecks);
        chart.setVisible(panel == chart);
        tarazName.setVisible(panel == tarazName);
        LoginPanel.setVisible(panel == LoginPanel);
        dashboard.setVisible(panel == dashboard);
        addcheckPanel.setVisible(panel == addcheckPanel);
        stateChangePanel.setVisible(panel == stateChangePanel);
        showDocPanel.setVisible(panel == showDocPanel);
        addDocPanel.setVisible(panel == addDocPanel);
        addPeoplePanel.setVisible(panel == addPeoplePanel);

        addCategoryPanel.setVisible(panel == addCategoryPanel);
        showCheckpanel.setVisible(panel == showCheckpanel);
        checksReport.setVisible(panel == checksReport);
        docsReport.setVisible(panel == docsReport);
        peopleReports.setVisible(panel == peopleReports);
    }

//==================sliders setting===================================
    public void SliderListener() {
        //checkSlider1.setMaximum(checkListMax);
        checkSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                checkCostFrom.setText("" + ((JSlider) e.getSource()).getValue());
            }
        });

        //  checkSlider2.setMaximum(checkListMax);
        checkSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                checkCostTo.setText("" + ((JSlider) e.getSource()).getValue());
            }
        });
        //  docSlider1.setMaximum(docListMax);

        docSlider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                DocCostFrom.setText("" + ((JSlider) e.getSource()).getValue());
            }
        });

        //docSlider2.setMaximum(docListMax);
        docSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                DocCostTo.setText("" + ((JSlider) e.getSource()).getValue());
            }
        });

    }

    public String filterSelector() {
        if (payeeCheckRBtn.isSelected()) {
            return "payee";
        } else if (TimeCheckRBtn.isSelected()) {
            return "time";
        } else if (costCheckRBtn.isSelected()) {
            return "cost";
        }
        return "";
    }

    public String filterDocSelector() {
        if (payeeDocRBtn.isSelected()) {
            return "payee";
        } else if (TimeDocRBtn.isSelected()) {
            return "time";
        } else if (costDocRBtn.isSelected()) {
            return "cost";
        }
        return "";
    }

    /**
     * @param args e command line argumentsthe command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardMenu().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JTextField DRangeChecksMonth;
    private javax.swing.JTextField DRangeChecksYear;
    private javax.swing.JTextField DRangeChecksYear1;
    private javax.swing.JTextField DRangeDocsDay3;
    private javax.swing.JTextField DRangeDocsDayFrom;
    private javax.swing.JTextField DRangeDocsDayTo;
    private javax.swing.JTextField DRangeDocsMonth2;
    private javax.swing.JTextField DRangeDocsMonthFrom;
    private javax.swing.JTextField DRangeDocsYear2;
    private javax.swing.JTextField DRangeDocsYearFrom;
    private javax.swing.JTextField DRangeDocsYearTo;
    private javax.swing.JTextField DRangeDocsmonthTo;
    private javax.swing.JLabel DocCostFrom;
    private javax.swing.JLabel DocCostTo;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JRadioButton MonthlyCheckRBtn;
    private javax.swing.JRadioButton MonthlyDoc;
    private javax.swing.JButton ShowChecksbtn;
    private javax.swing.JButton ShowDocsbtn;
    private javax.swing.JTextField TimeCheckAddDay;
    private javax.swing.JTextField TimeCheckAddMonth;
    private javax.swing.JTextField TimeCheckAddYear;
    private javax.swing.JRadioButton TimeCheckRBtn;
    private javax.swing.JRadioButton TimeDocRBtn;
    private javax.swing.JPanel addCategoryPanel;
    private javax.swing.JButton addCheckBack;
    private javax.swing.JButton addCheckBack1;
    private javax.swing.JScrollPane addCheckScroll;
    private javax.swing.JComboBox<String> addDocCombo;
    private javax.swing.JPanel addDocPanel;
    private javax.swing.JButton addDocback;
    private javax.swing.JTextField addId;
    private javax.swing.JTextField addName;
    private javax.swing.JPanel addPeoplePanel;
    private javax.swing.JButton addPeopleback;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JButton addback;
    private javax.swing.JButton addcategory;
    private javax.swing.JPanel addcheckPanel;
    private javax.swing.JPanel addingCheckPanel;
    private javax.swing.JPanel addingDocPanel;
    private javax.swing.JButton backCheckState;
    private javax.swing.JButton backToLogin;
    private javax.swing.JButton backshowCheck;
    private javax.swing.JButton backshowCheck1;
    private javax.swing.JButton backshowCheck2;
    private javax.swing.JButton backshowCheck3;
    private javax.swing.JButton backshowCheck4;
    private javax.swing.JButton backshowCheck5;
    private javax.swing.JButton backshowCheck6;
    private javax.swing.JButton backshowDoc;
    private javax.swing.JButton backshowDoc1;
    private javax.swing.JButton btnconfirm;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField categoryField;
    private javax.swing.JTextField categoryFieldEmail;
    private javax.swing.JTextField categoryFieldId;
    private javax.swing.JTextField categoryFieldName;
    private javax.swing.JTextField categoryFieldPhone;
    private javax.swing.JTextField categoryFieldَAddress;
    private javax.swing.JComboBox<String> changeStateComboBox;
    private javax.swing.JPanel chart;
    private javax.swing.JButton chartBtn;
    private javax.swing.JLabel checkCostFrom;
    private javax.swing.JLabel checkCostTo;
    private javax.swing.JTextField checkIdentifier;
    private javax.swing.JSlider checkSlider1;
    private javax.swing.JSlider checkSlider2;
    private javax.swing.JLabel checkWeightLabel;
    protected javax.swing.JPanel checksReport;
    private javax.swing.JTable checksTable;
    private javax.swing.JRadioButton clientBtn;
    private javax.swing.JButton confirmCategory;
    private javax.swing.JButton convertToDoc;
    private javax.swing.JRadioButton costCheckRBtn;
    private javax.swing.JTextField costDocAdd;
    private javax.swing.JRadioButton costDocRBtn;
    private javax.swing.JLabel costLabel;
    private javax.swing.JLabel costLabelCheck;
    private javax.swing.JLabel countCheck;
    private javax.swing.JLabel countDoc;
    private javax.swing.JRadioButton creditorBtn;
    private javax.swing.JRadioButton daily;
    private javax.swing.JRadioButton dailyCheckRBtn;
    private javax.swing.JPanel dashboard;
    private javax.swing.JButton dashboardBtnadd;
    private javax.swing.JButton dashboardBtnaddDoc;
    private javax.swing.JButton dashboardBtnshowCheck;
    private javax.swing.JButton dashboardBtnshowCheck1;
    private javax.swing.JButton dashboardBtnshowDoc;
    private javax.swing.JLabel dashboardlabel;
    private javax.swing.JRadioButton debtorBtn;
    private javax.swing.JScrollPane discriptionCheck;
    private javax.swing.JTextField discriptionDocAdd;
    private javax.swing.JTextArea discriptionTextAdd;
    private javax.swing.JTextField docDay;
    private javax.swing.JTextField docMonth;
    private javax.swing.JSlider docSlider1;
    private javax.swing.JSlider docSlider2;
    private javax.swing.JTextField docYear;
    protected javax.swing.JPanel docsReport;
    public javax.swing.JTable docsTable;
    private javax.swing.JTextField emailField;
    protected javax.swing.JTextField emailfieldLogin;
    private javax.swing.JRadioButton employeeBtn;
    private javax.swing.JButton enterBtn;
    private javax.swing.JTable filteredCheckTable;
    private javax.swing.JPanel filteredChecks;
    private javax.swing.JTable filteredDocTable;
    private javax.swing.JPanel filteredDocs;
    private javax.swing.JButton filteringChecks;
    private javax.swing.JButton filteringDocs;
    private javax.swing.ButtonGroup filters;
    private javax.swing.JButton groupDocSubmit;
    private javax.swing.JRadioButton isCashedBtn;
    private javax.swing.JToggleButton isCreditorToggle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JComboBox<String> monthsDocCombo;
    private javax.swing.JComboBox<String> monthscheckCombo;
    private javax.swing.JRadioButton partnerBtn;
    private javax.swing.JButton passWordRecovery;
    protected javax.swing.JTextField passwordField;
    private javax.swing.JRadioButton payeeCheckRBtn;
    private javax.swing.JTextField payeeCostAdd;
    private javax.swing.JRadioButton payeeDocRBtn;
    private javax.swing.JLabel payeeLabel;
    private javax.swing.JLabel payeeLabelCheck;
    private javax.swing.JComboBox<String> payeesComboBox;
    protected javax.swing.JComboBox<String> peopleCheckList;
    protected javax.swing.JComboBox<String> peopleDocList;
    private javax.swing.JPanel peopleReports;
    protected javax.swing.JTable peopleTable;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton registerChangeCheck;
    private javax.swing.JButton registerCheck;
    private javax.swing.JScrollPane scrollDoc;
    private javax.swing.JPanel showCheckpanel;
    private javax.swing.JPanel showDocPanel;
    private javax.swing.JButton showPeople;
    private javax.swing.JButton signInbtn;
    private javax.swing.JLabel sliderCheckLabel;
    private javax.swing.JPanel stateChangePanel;
    private javax.swing.JButton submitDoc;
    private javax.swing.JButton tarazBtn;
    private javax.swing.JPanel tarazName;
    private javax.swing.ButtonGroup timeFilter;
    private javax.swing.JRadioButton weeklyCheckRBtn;
    private javax.swing.JRadioButton weeklyDoc;
    // End of variables declaration//GEN-END:variables

    void paintComponent(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
