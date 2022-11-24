package nizekAccountant;

//import testProject.ButtonRounder;
import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.DocModels.CheckDoc;
import nizekAccountant.logic.DocModels.NormalDoc;
import nizekAccountant.logic.Login.Costumer;
import nizekAccountant.logic.Login.GroupType;
import nizekAccountant.logic.ModelManager.Manager;
import nizekAccountant.logic.AdminModel.Admin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
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
    private CreditorChart creditorChart;

    private FilterChecks filterChecks;
    private FilterDocs filterDocs;
    private GraphicsManager btnmanager;
 
    //  private ButtonRounder btnRounder;
    String checkFilter;
    String docFilter;

    private static boolean statusTimeZoneCHECK;
    private static boolean statusTimeZoneNORMAL;
    private static boolean statusTimeZoneFilteredCHECK;
    private static boolean statusTimeZoneFilteredNORMAL;
            ;
    

    boolean chart;


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

        userRepository.readAndAddAdmin(new File("/Users/persuara/Desktop/repository/adminFile.csv"));
        userRepository.readAndAddCostumer(new File("/Users/persuara/Desktop/repository/costumerFile.csv"));
        userRepository.readAndAddCheckDoc(new File("/Users/persuara/Desktop/repository/checkFile.csv"));
        userRepository.readAndAddNormalDoc(new File("/Users/persuara/Desktop/repository/normalFile.csv"));

        checkSlider1.setMaximum((int)userRepository.getMaxCheckDoc());//add check add doc
        System.out.println((int)userRepository.getMaxCheckDoc());
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

        checkRepo = new ShowCheckRepository(statusTimeZoneCHECK);
        peopleRepo = new ShowPeopleRepository();

        docRepo = new ShowDocRepository(statusTimeZoneNORMAL);

        creditorChart= new CreditorChart();
    //    chartFrame.setListD(NormalDoc.DayModel.generateDayModel(Manager.normalDocList));

        checksTable.setModel(checkRepo);
        docsTable.setModel(docRepo);
        peopleTable.setModel(peopleRepo);

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
        btnmanager.btnChangeColor(backToLoginPanelBtn);
        btnmanager.btnChangeColor(registerBtn);
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
        DRangeChecksYearFrom = new javax.swing.JTextField();
        DRangeChecksMonthFrom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DRangeCheckYearTo = new javax.swing.JTextField();
        DRangeCheckMonthTo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        DRangeChecksDayFrom = new javax.swing.JTextField();
        DRangeChecksDayTo = new javax.swing.JTextField();
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
        jalaliBtn = new javax.swing.JButton();
        gregorianBtn = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        removeCheckidBTN = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        docsReport = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        docsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        backshowCheck1 = new javax.swing.JButton();
        jalaliNormalBtn = new javax.swing.JButton();
        gregorianNormalBtn = new javax.swing.JButton();
        removeidTF = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        okRemoveBtn = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        peopleReports = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        peopleTable = new javax.swing.JTable();
        jLabel52 = new javax.swing.JLabel();
        backshowCheck2 = new javax.swing.JButton();
        tarazName = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        backshowCheck3 = new javax.swing.JButton();
        chartPanel = new javax.swing.JPanel();
        backshowCheck4 = new javax.swing.JButton();
        filteredDocs = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        filteredDocTable = new javax.swing.JTable();
        jLabel59 = new javax.swing.JLabel();
        backshowCheck5 = new javax.swing.JButton();
        iranfilteredNormalBtn = new javax.swing.JButton();
        gmtFilteredNormalBtn = new javax.swing.JButton();
        filteredChecks = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        filteredCheckTable = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        backshowCheck6 = new javax.swing.JButton();

        iranFilteredCHECK = new javax.swing.JButton();
        gmtFilteredCHECK = new javax.swing.JButton();
        registerPanel = new javax.swing.JPanel();
        userNameRegister = new javax.swing.JTextField();
        emailRegister = new javax.swing.JTextField();
        passwordRegister = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        backToLoginPanelBtn = new javax.swing.JButton();

        addGroupDocs = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        groupedDoc = new javax.swing.JTable();
        submitAll = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();


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

        LoginPanel.setBackground(new java.awt.Color(0, 1, 50));
        LoginPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        emailfieldLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        emailfieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailfieldLoginActionPerformed(evt);
            }
        });

        passWordRecovery.setBackground(new java.awt.Color(102, 102, 255));
        passWordRecovery.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        passWordRecovery.setForeground(new java.awt.Color(255, 255, 255));
        passWordRecovery.setText("رمز عبور را فراموش کردید؟ ");
        passWordRecovery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passWordRecoveryActionPerformed(evt);
            }
        });

        enterBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        enterBtn.setForeground(new java.awt.Color(102, 102, 255));
        enterBtn.setText("ورود");
        enterBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        enterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBtnActionPerformed(evt);
            }
        });

        signInbtn.setBackground(new java.awt.Color(102, 102, 255));
        signInbtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        signInbtn.setForeground(new java.awt.Color(255, 255, 255));
        signInbtn.setText("ثبت نام");
        signInbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInbtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ایمیل");

        jLabel21.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("رمز عبور");

        jLabel22.setBackground(new java.awt.Color(102, 102, 255));
        jLabel22.setFont(new java.awt.Font("B Roya", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("خوش آمدید");

        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(signInbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passWordRecovery))
                        .addGap(4, 4, 4)))
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailfieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(60, 60, 60)
                .addComponent(enterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(signInbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passWordRecovery, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        addcheckPanel.setBackground(new java.awt.Color(0, 1, 50));
        addcheckPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        addcheckPanel.setPreferredSize(new java.awt.Dimension(787, 746));

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

        addingCheckPanel.setBackground(new java.awt.Color(0, 1, 50));
        addingCheckPanel.setRequestFocusEnabled(false);
        addingCheckPanel.setSize(new java.awt.Dimension(750, 450));

        discriptionTextAdd.setColumns(20);
        discriptionTextAdd.setRows(5);
        discriptionTextAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
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

        payeeCostAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        payeeCostAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payeeCostAddActionPerformed(evt);
            }
        });


        TimeCheckAddDay.setBackground(new java.awt.Color(102, 102, 255));
        TimeCheckAddDay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        TimeCheckAddDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeCheckAddDayActionPerformed(evt);
            }
        });

        isCashedBtn.setBackground(new java.awt.Color(0, 1, 50));
        isCashedBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        isCashedBtn.setForeground(new java.awt.Color(102, 102, 255));
        isCashedBtn.setText("وصول شده است");
        isCashedBtn.setBorder(null);
        isCashedBtn.setBorderPainted(true);

        payeesComboBox.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        payeesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " ", " ", " ", " " }));
        payeesComboBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        payeesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payeesComboBoxActionPerformed(evt);
            }
        });

        TimeCheckAddYear.setBackground(new java.awt.Color(102, 102, 255));
        TimeCheckAddYear.setForeground(new java.awt.Color(255, 255, 255));
        TimeCheckAddYear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        TimeCheckAddYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeCheckAddYearActionPerformed(evt);
            }
        });

        TimeCheckAddMonth.setBackground(new java.awt.Color(102, 102, 255));
        TimeCheckAddMonth.setForeground(new java.awt.Color(255, 255, 255));
        TimeCheckAddMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

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
                        .addGap(99, 99, 99)
                        .addComponent(isCashedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(payeeCostAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(discriptionCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addingCheckPanelLayout.createSequentialGroup()
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addingCheckPanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel17))
                        .addGroup(addingCheckPanelLayout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(jLabel18)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingCheckPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
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
                    .addGroup(addingCheckPanelLayout.createSequentialGroup()
                        .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addingCheckPanelLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingCheckPanelLayout.createSequentialGroup()
                                .addComponent(payeeCostAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(addingCheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discriptionCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addingCheckPanelLayout.createSequentialGroup()
                        .addComponent(isCashedBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );

        addCheckScroll.setViewportView(addingCheckPanel);

        addCheckBack1.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addCheckBack1.setText("ثبت گروهی");
        addCheckBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCheckBack1ActionPerformed(evt);
            }
        });

        countCheck.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        countCheck.setText(" ");

        jLabel56.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("ثبت چک ققط برای طرف حساب های ثبت شده قابل انجام است");

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("افزودن شخص جدید");
        jButton2.setBorder(null);
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
                        .addComponent(addCheckScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addcheckPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addCheckBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addCheckBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
            .addGroup(addcheckPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        addcheckPanelLayout.setVerticalGroup(
            addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addcheckPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGroup(addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addcheckPanelLayout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(countCheck))
                    .addGroup(addcheckPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addCheckScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(addcheckPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCheckBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCheckBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        stateChangePanel.setBackground(new java.awt.Color(0, 1, 50));
        stateChangePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        stateChangePanel.setPreferredSize(new java.awt.Dimension(787, 746));

        jLabel25.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("طرف حساب");

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("شناسه چک");

        checkIdentifier.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        checkIdentifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkIdentifierActionPerformed(evt);
            }
        });

        registerChangeCheck.setBackground(new java.awt.Color(102, 102, 255));
        registerChangeCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        registerChangeCheck.setForeground(new java.awt.Color(255, 255, 255));
        registerChangeCheck.setText("ثبت");
        registerChangeCheck.setPreferredSize(dimension);
        registerChangeCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerChangeCheckActionPerformed(evt);
            }
        });

        isCreditorToggle.setBackground(new java.awt.Color(102, 102, 255));
        isCreditorToggle.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        isCreditorToggle.setForeground(new java.awt.Color(255, 255, 255));
        isCreditorToggle.setText("تغییر وضعیت");
        isCreditorToggle.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        isCreditorToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isCreditorToggleActionPerformed(evt);
            }
        });

        backCheckState.setBackground(new java.awt.Color(102, 102, 255));
        backCheckState.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backCheckState.setForeground(new java.awt.Color(255, 255, 255));
        backCheckState.setText("بازگشت به داشبورد اصلی");
        backCheckState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backCheckStateActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(102, 102, 255));
        jLabel30.setFont(new java.awt.Font("B Roya", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("تغییر وضعیت چک");

        changeStateComboBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        convertToDoc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        convertToDoc.setForeground(new java.awt.Color(102, 102, 255));
        convertToDoc.setText("تبدیل چک به سند");
        convertToDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        convertToDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertToDocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stateChangePanelLayout = new javax.swing.GroupLayout(stateChangePanel);
        stateChangePanel.setLayout(stateChangePanelLayout);
        stateChangePanelLayout.setHorizontalGroup(
            stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stateChangePanelLayout.createSequentialGroup()
                .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(stateChangePanelLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(changeStateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 166, Short.MAX_VALUE))
            .addGroup(stateChangePanelLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(isCreditorToggle, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(convertToDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stateChangePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        stateChangePanelLayout.setVerticalGroup(
            stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stateChangePanelLayout.createSequentialGroup()
                .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(stateChangePanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(changeStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26))
                    .addGroup(stateChangePanelLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(checkIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(isCreditorToggle, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(convertToDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addGroup(stateChangePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerChangeCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backCheckState, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        showDocPanel.setBackground(new java.awt.Color(0, 1, 50));
        showDocPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        showDocPanel.setPreferredSize(new java.awt.Dimension(787, 746));

        payeeLabel.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        payeeLabel.setForeground(new java.awt.Color(255, 255, 255));
        payeeLabel.setText("طرف حساب");

        ShowDocsbtn.setBackground(new java.awt.Color(102, 102, 255));
        ShowDocsbtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        ShowDocsbtn.setForeground(new java.awt.Color(255, 255, 255));
        ShowDocsbtn.setText("نمایش سندها");
        ShowDocsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowDocsbtnActionPerformed(evt);
            }
        });

        backshowDoc.setBackground(new java.awt.Color(102, 102, 255));
        backshowDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowDoc.setForeground(new java.awt.Color(255, 255, 255));
        backshowDoc.setText("بازگشت به داشبورد اصلی");
        backshowDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowDocActionPerformed(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(102, 102, 255));
        jLabel31.setFont(new java.awt.Font("B Roya", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("نمایش سند");

        timeFilter.add(daily);
        daily.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        daily.setForeground(new java.awt.Color(255, 255, 255));
        daily.setText("روزانه");
        daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyActionPerformed(evt);
            }
        });

        timeFilter.add(weeklyDoc);
        weeklyDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        weeklyDoc.setForeground(new java.awt.Color(255, 255, 255));
        weeklyDoc.setText("هفتگی");
        weeklyDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyDocActionPerformed(evt);
            }
        });

        timeFilter.add(MonthlyDoc);
        MonthlyDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        MonthlyDoc.setForeground(new java.awt.Color(255, 255, 255));
        MonthlyDoc.setText("ماهانه");
        MonthlyDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyDocActionPerformed(evt);
            }
        });

        monthsDocCombo.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        monthsDocCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد ", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن ", "اسفند" }));
        monthsDocCombo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        monthsDocCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthsDocComboActionPerformed(evt);
            }
        });

        peopleDocList.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        peopleDocList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
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
        TimeDocRBtn.setForeground(new java.awt.Color(102, 102, 255));
        TimeDocRBtn.setText("فیلتر زمان");
        TimeDocRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeDocRBtnActionPerformed(evt);
            }
        });

        filters.add(payeeDocRBtn);
        payeeDocRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        payeeDocRBtn.setForeground(new java.awt.Color(102, 102, 255));
        payeeDocRBtn.setText("طرف حساب");
        payeeDocRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payeeDocRBtnActionPerformed(evt);
            }
        });

        costDocRBtn.setBackground(new java.awt.Color(0, 1, 50));
        filters.add(costDocRBtn);
        costDocRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        costDocRBtn.setForeground(new java.awt.Color(102, 102, 255));
        costDocRBtn.setText("فیلتر قیمت");
        costDocRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costDocRBtnActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("فیلترها");

        jLabel23.setBackground(new java.awt.Color(102, 102, 255));
        jLabel23.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("بازه ی زمانی مورد نظر را وارد کنید");

        DRangeDocsMonthFrom.setBackground(new java.awt.Color(102, 102, 255));
        DRangeDocsMonthFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsMonthFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        DRangeDocsDayFrom.setBackground(new java.awt.Color(102, 102, 255));
        DRangeDocsDayFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsDayFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        DRangeDocsDayFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DRangeDocsDayFromActionPerformed(evt);
            }
        });

        DRangeDocsmonthTo.setBackground(new java.awt.Color(102, 102, 255));
        DRangeDocsmonthTo.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsmonthTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        DRangeDocsmonthTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DRangeDocsmonthToActionPerformed(evt);
            }
        });

        DRangeDocsDayTo.setBackground(new java.awt.Color(102, 102, 255));
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

        DRangeDocsYearFrom.setBackground(new java.awt.Color(102, 102, 255));
        DRangeDocsYearFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsYearFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        DRangeDocsYearTo.setBackground(new java.awt.Color(102, 102, 255));
        DRangeDocsYearTo.setForeground(new java.awt.Color(255, 255, 255));
        DRangeDocsYearTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        docSlider1.setBackground(new java.awt.Color(255, 255, 255));
        docSlider1.setForeground(new java.awt.Color(51, 51, 255));

        docSlider2.setBackground(new java.awt.Color(255, 255, 255));
        docSlider2.setForeground(new java.awt.Color(51, 51, 255));

        DocCostFrom.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DocCostFrom.setForeground(new java.awt.Color(255, 255, 255));
        DocCostFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "از", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        DocCostTo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DocCostTo.setForeground(new java.awt.Color(255, 255, 255));
        DocCostTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "تا", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        filteringDocs.setBackground(new java.awt.Color(102, 102, 255));
        filteringDocs.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        filteringDocs.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGap(35, 35, 35)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(showDocPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(docSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                    .addComponent(docSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DocCostTo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DocCostFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(showDocPanelLayout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(showDocPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46))
                                    .addGroup(showDocPanelLayout.createSequentialGroup()
                                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(payeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(peopleDocList, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, showDocPanelLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(showDocPanelLayout.createSequentialGroup()
                                .addComponent(backshowDoc)
                                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(showDocPanelLayout.createSequentialGroup()
                                        .addGap(309, 309, 309)
                                        .addComponent(jLabel31))
                                    .addGroup(showDocPanelLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(ShowDocsbtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(filteringDocs))))
                            .addGroup(showDocPanelLayout.createSequentialGroup()
                                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(costDocRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(87, 87, 87)))
                                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(showDocPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(payeeDocRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(TimeDocRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(80, 80, 80)))
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
                            .addComponent(monthsDocCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel57))
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel31)
                        .addGap(26, 26, 26)
                        .addComponent(payeeDocRBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimeDocRBtn)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costDocRBtn)
                .addGap(32, 32, 32)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DocCostFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(docSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DocCostTo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(docSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showDocPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showDocPanelLayout.createSequentialGroup()
                                .addComponent(payeeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(peopleDocList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
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
                        .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DRangeDocsMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)
                            .addComponent(jLabel51)
                            .addComponent(DRangeDocsYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeDocsDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(showDocPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addGroup(showDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backshowDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowDocsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filteringDocs, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        addDocPanel.setBackground(new java.awt.Color(0, 1, 50));
        addDocPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        addDocPanel.setForeground(new java.awt.Color(204, 204, 204));

        scrollDoc.setBackground(new java.awt.Color(204, 255, 153));
        scrollDoc.setPreferredSize(new java.awt.Dimension(700, 450));

        addingDocPanel.setBackground(new java.awt.Color(0, 1, 50));
        addingDocPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setBackground(new java.awt.Color(153, 153, 153));
        jLabel15.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("مبلغ");

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("توضیحات");

        discriptionDocAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        costDocAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        costDocAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costDocAddActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("مشخصات سند");

        creditorBtn.setBackground(new java.awt.Color(0, 1, 50));
        buttonGroup2.add(creditorBtn);
        creditorBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        creditorBtn.setForeground(new java.awt.Color(255, 255, 255));
        creditorBtn.setText("بستانکار");

        debtorBtn.setBackground(new java.awt.Color(0, 1, 50));
        buttonGroup2.add(debtorBtn);
        debtorBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        debtorBtn.setForeground(new java.awt.Color(255, 255, 255));
        debtorBtn.setText("بدهکار");

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("طرف حساب");

        addDocCombo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("______________________________________________________________________________________________________________________________");

        docMonth.setBackground(new java.awt.Color(102, 102, 255));
        docMonth.setForeground(new java.awt.Color(255, 255, 255));
        docMonth.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        docMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docMonthActionPerformed(evt);
            }
        });

        docDay.setBackground(new java.awt.Color(102, 102, 255));
        docDay.setForeground(new java.awt.Color(255, 255, 255));
        docDay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        docYear.setBackground(new java.awt.Color(102, 102, 255));
        docYear.setForeground(new java.awt.Color(255, 255, 255));
        docYear.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout addingDocPanelLayout = new javax.swing.GroupLayout(addingDocPanel);
        addingDocPanel.setLayout(addingDocPanelLayout);
        addingDocPanelLayout.setHorizontalGroup(
            addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingDocPanelLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
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
                                .addComponent(docDay, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addingDocPanelLayout.createSequentialGroup()
                                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(costDocAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(discriptionDocAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(addDocCombo, 0, 250, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)))
                            .addGroup(addingDocPanelLayout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(jLabel13))))
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        addingDocPanelLayout.setVerticalGroup(
            addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addingDocPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(debtorBtn))
                .addGap(18, 18, 18)
                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(creditorBtn)
                    .addComponent(addDocCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(costDocAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addingDocPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel16))
                    .addGroup(addingDocPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(discriptionDocAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addingDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(docMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(docDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(docYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38)
                .addComponent(jLabel39)
                .addContainerGap(220, Short.MAX_VALUE))
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
        groupDocSubmit.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        groupDocSubmit.setForeground(new java.awt.Color(255, 255, 255));
        groupDocSubmit.setText("ثبت گروهی اسناد");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocPanelLayout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addGap(32, 32, 32))
                        .addGroup(addDocPanelLayout.createSequentialGroup()
                            .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1)
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(139, 139, 139)
                            .addComponent(countDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addDocPanelLayout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addComponent(addDocback)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(submitDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(groupDocSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(scrollDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)))

        );
        addDocPanelLayout.setVerticalGroup(
            addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addDocPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(scrollDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocPanelLayout.createSequentialGroup()
                        .addGroup(addDocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addDocback, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupDocSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocPanelLayout.createSequentialGroup()
                        .addComponent(countDoc)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDocPanelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(169, 169, 169))))
        );

        addPeoplePanel.setBackground(new java.awt.Color(0, 1, 50));
        addPeoplePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        addPeoplePanel.setForeground(new java.awt.Color(255, 255, 255));
        addPeoplePanel.setPreferredSize(new java.awt.Dimension(787, 746));

        addName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 125, 255), 4, true));
        addName.setPreferredSize(new java.awt.Dimension(70, 30));
        addName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNameActionPerformed(evt);
            }
        });

        addId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 125, 255), 4, true));
        addId.setPreferredSize(new java.awt.Dimension(70, 30));

        AddressField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 125, 255), 4, true));
        AddressField.setPreferredSize(new java.awt.Dimension(70, 50));

        phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 125, 255), 4, true));
        phoneField.setPreferredSize(new java.awt.Dimension(70, 30));

        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 125, 255), 4, true));
        emailField.setPreferredSize(new java.awt.Dimension(70, 30));
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

        addcategory.setBackground(new java.awt.Color(125, 125, 255));
        addcategory.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        addcategory.setForeground(new java.awt.Color(255, 255, 255));
        addcategory.setText("افزودن دسته بندی جدید");
        addcategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 125, 255), 4, true));
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
                .addContainerGap(289, Short.MAX_VALUE)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPeoplePanelLayout.createSequentialGroup()
                            .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(addId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)
                            .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPeoplePanelLayout.createSequentialGroup()
                            .addComponent(addPeopleback)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPeoplePanelLayout.createSequentialGroup()
                            .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(addPeoplePanelLayout.createSequentialGroup()
                                    .addComponent(partnerBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(clientBtn)
                                    .addGap(27, 27, 27)
                                    .addComponent(employeeBtn))
                                .addComponent(addcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)))
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
                    .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(partnerBtn)
                    .addComponent(clientBtn)
                    .addComponent(employeeBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPeoplePanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(AddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addPeoplePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(addPeoplePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPeopleback, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        addCategoryPanel.setBackground(new java.awt.Color(0, 1, 50));
        addCategoryPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        addCategoryPanel.setForeground(new java.awt.Color(255, 255, 255));
        addCategoryPanel.setPreferredSize(new java.awt.Dimension(787, 746));

        jLabel6.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("عنوان دسته بندی");

        categoryField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        confirmCategory.setBackground(new java.awt.Color(102, 102, 255));
        confirmCategory.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        confirmCategory.setForeground(new java.awt.Color(255, 255, 255));
        confirmCategory.setText("ثبت");
        confirmCategory.setPreferredSize(dimension);
        confirmCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmCategoryActionPerformed(evt);
            }
        });

        addback.setBackground(new java.awt.Color(102, 102, 255));
        addback.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addback.setForeground(new java.awt.Color(255, 255, 255));
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

        categoryFieldName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        categoryFieldEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        categoryFieldId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        categoryFieldPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        categoryFieldَAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        jLabel34.setBackground(new java.awt.Color(102, 102, 255));
        jLabel34.setFont(new java.awt.Font("B Roya", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("افزودن دسته بندی جدید");

        javax.swing.GroupLayout addCategoryPanelLayout = new javax.swing.GroupLayout(addCategoryPanel);
        addCategoryPanel.setLayout(addCategoryPanelLayout);
        addCategoryPanelLayout.setHorizontalGroup(
            addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCategoryPanelLayout.createSequentialGroup()
                .addGap(0, 220, Short.MAX_VALUE)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addCategoryPanelLayout.createSequentialGroup()
                        .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(categoryFieldَAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(categoryFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(categoryFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(categoryFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(categoryFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addCategoryPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addCategoryPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(69, 69, 69))
            .addGroup(addCategoryPanelLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(addback)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        addCategoryPanelLayout.setVerticalGroup(
            addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCategoryPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCategoryPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCategoryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryFieldَAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                .addGroup(addCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addback, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        dashboard.setBackground(new java.awt.Color(0, 1, 50));
        dashboard.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        dashboardBtnshowCheck.setBackground(new java.awt.Color(179, 145, 138));
        dashboardBtnshowCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnshowCheck.setForeground(new java.awt.Color(228, 226, 217));
        dashboardBtnshowCheck.setText("نمایش چک");
        dashboardBtnshowCheck.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
        dashboardBtnshowCheck.setPreferredSize(new java.awt.Dimension(103, 26));
        dashboardBtnshowCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnshowCheckActionPerformed(evt);
            }
        });

        addUserBtn.setBackground(new java.awt.Color(179, 145, 138));
        addUserBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        addUserBtn.setForeground(new java.awt.Color(228, 226, 217));
        addUserBtn.setText("افزودن اشخاص");
        addUserBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
        addUserBtn.setPreferredSize(new java.awt.Dimension(103, 26));
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        dashboardBtnshowDoc.setBackground(new java.awt.Color(179, 145, 138));
        dashboardBtnshowDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnshowDoc.setForeground(new java.awt.Color(228, 226, 217));
        dashboardBtnshowDoc.setText("نمایش سند");
        dashboardBtnshowDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
        dashboardBtnshowDoc.setPreferredSize(new java.awt.Dimension(103, 26));
        dashboardBtnshowDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnshowDocActionPerformed(evt);
            }
        });

        dashboardBtnadd.setBackground(new java.awt.Color(179, 145, 138));
        dashboardBtnadd.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnadd.setForeground(new java.awt.Color(228, 226, 217));
        dashboardBtnadd.setText("افزودن چک");
        dashboardBtnadd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
        dashboardBtnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnaddActionPerformed(evt);
            }
        });

        dashboardBtnaddDoc.setBackground(new java.awt.Color(179, 145, 138));
        dashboardBtnaddDoc.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnaddDoc.setForeground(new java.awt.Color(228, 226, 217));
        dashboardBtnaddDoc.setText("افزودن سند");
        dashboardBtnaddDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
        dashboardBtnaddDoc.setPreferredSize(new java.awt.Dimension(103, 26));
        dashboardBtnaddDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnaddDocActionPerformed(evt);
            }
        });

        dashboardlabel.setBackground(new java.awt.Color(102, 102, 255));
        dashboardlabel.setFont(new java.awt.Font("B Roya", 1, 48)); // NOI18N
        dashboardlabel.setForeground(new java.awt.Color(255, 255, 255));
        dashboardlabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dashboardlabel.setText("حسابدار نایزک");
        dashboardlabel.setToolTipText("");
        dashboardlabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tarazBtn.setBackground(new java.awt.Color(179, 145, 138));
        tarazBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        tarazBtn.setForeground(new java.awt.Color(228, 226, 217));
        tarazBtn.setText("نمودار تراز");
        tarazBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
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

        dashboardBtnshowCheck1.setBackground(new java.awt.Color(179, 145, 138));
        dashboardBtnshowCheck1.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dashboardBtnshowCheck1.setForeground(new java.awt.Color(228, 226, 217));
        dashboardBtnshowCheck1.setText("تغییر وضعیت چک");
        dashboardBtnshowCheck1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
        dashboardBtnshowCheck1.setMaximumSize(new java.awt.Dimension(140, 109));
        dashboardBtnshowCheck1.setPreferredSize(new java.awt.Dimension(103, 26));
        dashboardBtnshowCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardBtnshowCheck1ActionPerformed(evt);
            }
        });

        showPeople.setBackground(new java.awt.Color(179, 145, 138));
        showPeople.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        showPeople.setForeground(new java.awt.Color(228, 226, 217));
        showPeople.setText("نمایش اشخاص");
        showPeople.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
        showPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPeopleActionPerformed(evt);
            }
        });

        chartBtn.setBackground(new java.awt.Color(179, 145, 138));
        chartBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        chartBtn.setForeground(new java.awt.Color(228, 226, 217));
        chartBtn.setText("نمودار بدهکاری");
        chartBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(228, 226, 217), 3, true));
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
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backToLogin))
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dashboardBtnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dashboardBtnaddDoc, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showPeople, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(dashboardBtnshowCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dashboardBtnshowDoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dashboardLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dashboardBtnshowCheck1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(chartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tarazBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(330, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(dashboardlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(dashboardlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 452, Short.MAX_VALUE)
                .addComponent(backToLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        showCheckpanel.setBackground(new java.awt.Color(0, 1, 50));
        showCheckpanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        showCheckpanel.setForeground(new java.awt.Color(255, 255, 255));
        showCheckpanel.setPreferredSize(new java.awt.Dimension(787, 746));

        payeeLabelCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        payeeLabelCheck.setForeground(new java.awt.Color(255, 255, 255));
        payeeLabelCheck.setText("طرف حساب");

        ShowChecksbtn.setBackground(new java.awt.Color(102, 102, 255));
        ShowChecksbtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        ShowChecksbtn.setForeground(new java.awt.Color(255, 255, 255));
        ShowChecksbtn.setText("نمایش چک ها");
        ShowChecksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowChecksbtnActionPerformed(evt);
            }
        });

        backshowDoc1.setBackground(new java.awt.Color(102, 102, 255));
        backshowDoc1.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowDoc1.setForeground(new java.awt.Color(255, 255, 255));
        backshowDoc1.setText("بازگشت به داشبورد اصلی");
        backshowDoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowDoc1ActionPerformed(evt);
            }
        });

        timeFilter.add(dailyCheckRBtn);
        dailyCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        dailyCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        dailyCheckRBtn.setText("روزانه");
        dailyCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyCheckRBtnActionPerformed(evt);
            }
        });

        timeFilter.add(weeklyCheckRBtn);
        weeklyCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        weeklyCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        weeklyCheckRBtn.setText("هفتگی");
        weeklyCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyCheckRBtnActionPerformed(evt);
            }
        });

        timeFilter.add(MonthlyCheckRBtn);
        MonthlyCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        MonthlyCheckRBtn.setForeground(new java.awt.Color(255, 255, 255));
        MonthlyCheckRBtn.setText("ماهانه");
        MonthlyCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthlyCheckRBtnActionPerformed(evt);
            }
        });

        monthscheckCombo.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        monthscheckCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد ", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن ", "اسفند" }));
        monthscheckCombo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        monthscheckCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthscheckComboActionPerformed(evt);
            }
        });

        peopleCheckList.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        peopleCheckList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        peopleCheckList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peopleCheckListActionPerformed(evt);
            }
        });

        costLabelCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        costLabelCheck.setForeground(new java.awt.Color(255, 255, 255));
        costLabelCheck.setText("مبلغ");

        TimeCheckRBtn.setBackground(new java.awt.Color(0, 1, 50));
        filters.add(TimeCheckRBtn);
        TimeCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        TimeCheckRBtn.setForeground(new java.awt.Color(102, 102, 255));
        TimeCheckRBtn.setText("فیلتر زمان");
        TimeCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeCheckRBtnActionPerformed(evt);
            }
        });

        filters.add(payeeCheckRBtn);
        payeeCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        payeeCheckRBtn.setForeground(new java.awt.Color(102, 102, 255));
        payeeCheckRBtn.setText("طرف حساب");
        payeeCheckRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payeeCheckRBtnActionPerformed(evt);
            }
        });

        filters.add(costCheckRBtn);
        costCheckRBtn.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        costCheckRBtn.setForeground(new java.awt.Color(102, 102, 255));
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


        DRangeChecksYearFrom.setBackground(new java.awt.Color(102, 102, 255));
        DRangeChecksYearFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeChecksYearFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        DRangeChecksMonthFrom.setBackground(new java.awt.Color(102, 102, 255));
        DRangeChecksMonthFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeChecksMonthFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        DRangeChecksMonthFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DRangeChecksMonthFromActionPerformed(evt);
            }
        });


        jLabel5.setFont(new java.awt.Font("B Roya", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("نمایش چک ها");

        DRangeCheckYearTo.setBackground(new java.awt.Color(102, 102, 255));
        DRangeCheckYearTo.setForeground(new java.awt.Color(255, 255, 255));
        DRangeCheckYearTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "سال", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        DRangeCheckMonthTo.setBackground(new java.awt.Color(102, 102, 255));
        DRangeCheckMonthTo.setForeground(new java.awt.Color(255, 255, 255));
        DRangeCheckMonthTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ماه", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        DRangeCheckMonthTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DRangeCheckMonthToActionPerformed(evt);
            }
        });


        jLabel28.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("از تاریخ");

        jLabel35.setFont(new java.awt.Font("B Roya", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("تا تاریخ");


        DRangeChecksDayFrom.setBackground(new java.awt.Color(102, 102, 255));
        DRangeChecksDayFrom.setForeground(new java.awt.Color(255, 255, 255));
        DRangeChecksDayFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        DRangeChecksDayFrom.setCaretColor(new java.awt.Color(255, 255, 255));

        DRangeChecksDayTo.setBackground(new java.awt.Color(102, 102, 255));
        DRangeChecksDayTo.setForeground(new java.awt.Color(255, 255, 255));
        DRangeChecksDayTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "روز", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N


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

        filteringChecks.setBackground(new java.awt.Color(102, 102, 255));
        filteringChecks.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        filteringChecks.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGap(26, 26, 26)
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderCheckLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DRangeChecksYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeCheckYearTo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jLabel47))
                        .addGap(11, 11, 11)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addComponent(DRangeCheckMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DRangeChecksDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addComponent(DRangeChecksMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DRangeChecksDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(showCheckpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkCostFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkCostTo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(payeeLabelCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peopleCheckList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                                .addComponent(monthscheckCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MonthlyCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(weeklyCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dailyCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TimeCheckRBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(payeeCheckRBtn))))
                            .addComponent(costCheckRBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(costLabelCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(349, 349, 349))
            .addGroup(showCheckpanelLayout.createSequentialGroup()
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(138, 138, 138)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backshowDoc1)
                        .addGap(37, 37, 37)))
                .addComponent(ShowChecksbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filteringChecks)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showCheckpanelLayout.setVerticalGroup(
            showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showCheckpanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(checkSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(checkSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(showCheckpanelLayout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(checkCostFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkCostTo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(payeeCheckRBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dailyCheckRBtn)
                            .addComponent(weeklyCheckRBtn)
                            .addComponent(MonthlyCheckRBtn)
                            .addComponent(monthscheckCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TimeCheckRBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(costCheckRBtn)
                        .addGap(88, 88, 88)
                        .addComponent(costLabelCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(payeeLabelCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(peopleCheckList, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(sliderCheckLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showCheckpanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(showCheckpanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DRangeChecksYearFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeChecksMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeChecksDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel45)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DRangeCheckYearTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeCheckMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DRangeChecksDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47))
                        .addGap(43, 43, 43)))
                .addGroup(showCheckpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowChecksbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backshowDoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filteringChecks, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        checksReport.setBackground(new java.awt.Color(0, 1, 50));
        checksReport.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        checksReport.setFont(new java.awt.Font("B Roya", 0, 14)); // NOI18N
        checksReport.setPreferredSize(new java.awt.Dimension(787, 746));

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("نمایش چک ها");

        backshowCheck.setBackground(new java.awt.Color(102, 102, 255));
        backshowCheck.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck.setForeground(new java.awt.Color(255, 255, 255));
        backshowCheck.setText("بازگشت به داشبورد ");
        backshowCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheckActionPerformed(evt);
            }
        });

        checkWeightLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        checkWeightLabel.setForeground(new java.awt.Color(255, 255, 255));
        checkWeightLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "راس چک", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        jalaliBtn.setForeground(new java.awt.Color(0, 1, 50));
        jalaliBtn.setText("منطقه زمانی ایران");
        jalaliBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        jalaliBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jalaliBtnActionPerformed(evt);
            }
        });

        gregorianBtn.setForeground(new java.awt.Color(0, 1, 50));
        gregorianBtn.setText("منطقه زمانی گرینویج");
        gregorianBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        gregorianBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gregorianBtnActionPerformed(evt);
            }
        });

        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("اگر میخواهید چکی را حذف کنید شناسه آن را در فیلد زیر وارد کنید");

        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("و ثبت را دوبار فشار دهید");

        removeCheckidBTN.setText("0");
        removeCheckidBTN.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("ثبت");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checksReportLayout = new javax.swing.GroupLayout(checksReport);
        checksReport.setLayout(checksReportLayout);
        checksReportLayout.setHorizontalGroup(
            checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checksReportLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checksReportLayout.createSequentialGroup()
                        .addGroup(checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backshowCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkWeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(checksReportLayout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addGroup(checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jalaliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gregorianBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(checksReportLayout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checksReportLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checksReportLayout.createSequentialGroup()
                        .addComponent(removeCheckidBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel66)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checksReportLayout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        checksReportLayout.setVerticalGroup(
            checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checksReportLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)

                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checksReportLayout.createSequentialGroup()
                        .addComponent(jalaliBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gregorianBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkWeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(removeCheckidBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(checksReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backshowCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))

        );

        docsReport.setBackground(new java.awt.Color(0, 1, 50));
        docsReport.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        docsReport.setPreferredSize(new java.awt.Dimension(787, 746));

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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("نمایش سند ها");

        backshowCheck1.setBackground(new java.awt.Color(102, 102, 255));
        backshowCheck1.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck1.setForeground(new java.awt.Color(255, 255, 255));
        backshowCheck1.setText("بازگشت به داشبورد اصلی ");
        backshowCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck1ActionPerformed(evt);
            }
        });

        jalaliNormalBtn.setForeground(new java.awt.Color(0, 1, 50));
        jalaliNormalBtn.setText("منطقه زمانی ایران");
        jalaliNormalBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        jalaliNormalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jalaliNormalBtnActionPerformed(evt);
            }
        });

        gregorianNormalBtn.setForeground(new java.awt.Color(0, 1, 50));
        gregorianNormalBtn.setText("منطقه زمانی گرینویچ");
        gregorianNormalBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        gregorianNormalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gregorianNormalBtnActionPerformed(evt);
            }
        });

        removeidTF.setText("0");
        removeidTF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        removeidTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeidTFActionPerformed(evt);
            }
        });

        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("اگر میخواهید سندی را حذف کنید شناسه آن را در فیلد زیر وارد کنید");

        okRemoveBtn.setText("ثبت");
        okRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okRemoveBtnActionPerformed(evt);
            }
        });

        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("و ثبت را دوبار فشار دهید");
        jLabel64.setToolTipText("");

        javax.swing.GroupLayout docsReportLayout = new javax.swing.GroupLayout(docsReport);
        docsReport.setLayout(docsReportLayout);
        docsReportLayout.setHorizontalGroup(
            docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docsReportLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(backshowCheck1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(docsReportLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docsReportLayout.createSequentialGroup()
                                .addComponent(removeidTF, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))
                    .addGroup(docsReportLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(okRemoveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docsReportLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docsReportLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docsReportLayout.createSequentialGroup()
                        .addGroup(docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jalaliNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gregorianNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(161, 161, 161))))
        );
        docsReportLayout.setVerticalGroup(
            docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docsReportLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)

                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jalaliNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gregorianNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(docsReportLayout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(backshowCheck1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(docsReportLayout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(docsReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeidTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(okRemoveBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))

        );

        peopleReports.setBackground(new java.awt.Color(0, 1, 50));
        peopleReports.setPreferredSize(new java.awt.Dimension(787, 746));

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

        jLabel52.setFont(new java.awt.Font("B Roya", 1, 24)); // NOI18N
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
                .addComponent(backshowCheck2)
                .addContainerGap(600, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, peopleReportsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        peopleReportsLayout.setVerticalGroup(
            peopleReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, peopleReportsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(backshowCheck2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tarazName.setPreferredSize(new java.awt.Dimension(787, 746));

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(tarazNameLayout.createSequentialGroup()
                        .addComponent(backshowCheck3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tarazNameLayout.setVerticalGroup(
            tarazNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tarazNameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(backshowCheck3)
                .addContainerGap())
        );

        chart.setPreferredSize(new java.awt.Dimension(787, 746));

        backshowCheck4.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck4.setText("بازگشت به داشبورد ");
        backshowCheck4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chartPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backshowCheck4)
                .addContainerGap(600, Short.MAX_VALUE))
        );

        chartLayout.setVerticalGroup(
            chartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chartLayout.createSequentialGroup()
                .addContainerGap(712, Short.MAX_VALUE)

                .addComponent(backshowCheck4)
                .addContainerGap())
        );

        filteredDocs.setBackground(new java.awt.Color(0, 1, 50));
        filteredDocs.setPreferredSize(new java.awt.Dimension(787, 746));

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

        jLabel59.setFont(new java.awt.Font("B Roya", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("نمایش سند های فیلتر شده");

        backshowCheck5.setBackground(new java.awt.Color(102, 102, 255));
        backshowCheck5.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck5.setForeground(new java.awt.Color(255, 255, 255));
        backshowCheck5.setText("بازگشت به داشبورد اصلی  ");
        backshowCheck5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck5ActionPerformed(evt);
            }
        });

        iranfilteredNormalBtn.setForeground(new java.awt.Color(0, 1, 50));
        iranfilteredNormalBtn.setText("منطقه زمانی ایران");
        iranfilteredNormalBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        iranfilteredNormalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iranfilteredNormalBtnActionPerformed(evt);
            }
        });

        gmtFilteredNormalBtn.setForeground(new java.awt.Color(0, 1, 50));
        gmtFilteredNormalBtn.setText("منطقه زمانی گرینویچ");
        gmtFilteredNormalBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        gmtFilteredNormalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gmtFilteredNormalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filteredDocsLayout = new javax.swing.GroupLayout(filteredDocs);
        filteredDocs.setLayout(filteredDocsLayout);
        filteredDocsLayout.setHorizontalGroup(
            filteredDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(filteredDocsLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(backshowCheck5, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredDocsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(filteredDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredDocsLayout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredDocsLayout.createSequentialGroup()
                        .addGroup(filteredDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gmtFilteredNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iranfilteredNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(159, 159, 159))))
        );
        filteredDocsLayout.setVerticalGroup(
            filteredDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredDocsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(iranfilteredNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gmtFilteredNormalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(backshowCheck5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        filteredChecks.setBackground(new java.awt.Color(0, 1, 50));
        filteredChecks.setPreferredSize(new java.awt.Dimension(787, 746));

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

        jLabel58.setFont(new java.awt.Font("B Roya", 1, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("نمایش چک های فیلتر شده");

        backshowCheck6.setBackground(new java.awt.Color(102, 102, 255));
        backshowCheck6.setFont(new java.awt.Font("B Roya", 1, 18)); // NOI18N
        backshowCheck6.setForeground(new java.awt.Color(255, 255, 255));
        backshowCheck6.setText("بازگشت به داشبورد اصلی ");
        backshowCheck6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backshowCheck6ActionPerformed(evt);
            }
        });

        iranFilteredCHECK.setForeground(new java.awt.Color(0, 1, 50));
        iranFilteredCHECK.setText("منطقه زمانی ایران");
        iranFilteredCHECK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        iranFilteredCHECK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iranFilteredCHECKActionPerformed(evt);
            }
        });

        gmtFilteredCHECK.setForeground(new java.awt.Color(0, 1, 50));
        gmtFilteredCHECK.setText("منطقه زمانی گرینویچ");
        gmtFilteredCHECK.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        gmtFilteredCHECK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gmtFilteredCHECKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filteredChecksLayout = new javax.swing.GroupLayout(filteredChecks);
        filteredChecks.setLayout(filteredChecksLayout);
        filteredChecksLayout.setHorizontalGroup(
            filteredChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(filteredChecksLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(backshowCheck6, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredChecksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(filteredChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredChecksLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredChecksLayout.createSequentialGroup()
                        .addGroup(filteredChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gmtFilteredCHECK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iranFilteredCHECK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156))))
        );
        filteredChecksLayout.setVerticalGroup(
            filteredChecksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filteredChecksLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(iranFilteredCHECK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gmtFilteredCHECK, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backshowCheck6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        registerPanel.setBackground(new java.awt.Color(0, 1, 50));

        userNameRegister.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        emailRegister.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        passwordRegister.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));

        jLabel20.setBackground(new java.awt.Color(0, 1, 50));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("نام کاربری");

        jLabel60.setBackground(new java.awt.Color(0, 1, 50));
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("ایمیل");

        jLabel61.setBackground(new java.awt.Color(0, 1, 50));
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("پسورد");

        jLabel62.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("همین حالا ثبت نام کنید");

        registerBtn.setForeground(new java.awt.Color(102, 102, 255));
        registerBtn.setText("ثبت نام");
        registerBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 4, true));
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        backToLoginPanelBtn.setBackground(new java.awt.Color(102, 102, 255));
        backToLoginPanelBtn.setForeground(new java.awt.Color(255, 255, 255));
        backToLoginPanelBtn.setText("ورود به حساب کاربری");
        backToLoginPanelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToLoginPanelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(backToLoginPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel62)))
                .addContainerGap(318, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addComponent(userNameRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60)))
                    .addComponent(jLabel20))
                .addGap(27, 27, 27)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(18, 18, 18)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backToLoginPanelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        groupedDoc.setFont(new java.awt.Font("B Nazanin", 1, 12)); // NOI18N
        groupedDoc.setModel(new javax.swing.table.DefaultTableModel(
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
        groupedDoc.setToolTipText("");
        jScrollPane7.setViewportView(groupedDoc);

        submitAll.setText("ثبت همه اسناد");
        submitAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAllActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addGroupDocsLayout = new javax.swing.GroupLayout(addGroupDocs);
        addGroupDocs.setLayout(addGroupDocsLayout);
        addGroupDocsLayout.setHorizontalGroup(
            addGroupDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addGroupDocsLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(submitAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
            .addGroup(addGroupDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addGroupDocsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        addGroupDocsLayout.setVerticalGroup(
            addGroupDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addGroupDocsLayout.createSequentialGroup()
                .addContainerGap(515, Short.MAX_VALUE)
                .addGroup(addGroupDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitAll, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(addGroupDocsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(addGroupDocsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(108, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 199, Short.MAX_VALUE)
                    .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 200, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(addcheckPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1121, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 166, Short.MAX_VALUE)
                    .addComponent(stateChangePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 166, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(showDocPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 356, Short.MAX_VALUE)
                    .addComponent(addDocPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 166, Short.MAX_VALUE)
                    .addComponent(addPeoplePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 166, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 166, Short.MAX_VALUE)
                    .addComponent(addCategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 166, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(showCheckpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 166, Short.MAX_VALUE)
                    .addComponent(checksReport, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 166, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()

                    .addGap(0, 166, Short.MAX_VALUE)
                    .addComponent(docsReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 166, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 93, Short.MAX_VALUE)
                    .addComponent(peopleReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 94, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(72, Short.MAX_VALUE)
                    .addComponent(tarazName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(49, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 72, Short.MAX_VALUE)
                    .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 72, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()

                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(docsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 166, Short.MAX_VALUE)
                    .addComponent(peopleReports, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 166, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(177, Short.MAX_VALUE)
                    .addComponent(tarazName, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(155, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 166, Short.MAX_VALUE)
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 166, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filteredDocs, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filteredChecks, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addGroupDocs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 238, Short.MAX_VALUE)
                    .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 238, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(addcheckPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 155, Short.MAX_VALUE)
                    .addComponent(stateChangePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 156, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(showDocPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addDocPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 156, Short.MAX_VALUE)
                    .addComponent(addPeoplePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 155, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 155, Short.MAX_VALUE)
                    .addComponent(addCategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 156, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(showCheckpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 156, Short.MAX_VALUE)
                    .addComponent(checksReport, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 86, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()

                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(docsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 155, Short.MAX_VALUE)
                    .addComponent(peopleReports, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 156, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(125, Short.MAX_VALUE)
                    .addComponent(tarazName, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(186, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 155, Short.MAX_VALUE)
                    .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 156, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filteredDocs, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(filteredChecks, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addGroupDocs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        String email = emailfieldLogin.getText().trim().toLowerCase();
        String password = passwordField.getText().trim().toLowerCase();
//        loginLogic = new LoginLogic();
        boolean isEligible = userRepository.validateAdmin(email, password);
        
        if (isEligible) {
            landPage(dashboard);
        } else {
             JOptionPane.showMessageDialog(addDocPanel, "کاربری با مشخصات ورودی شما یافت نشد",
                "", JOptionPane.ERROR_MESSAGE);
        }
        String name = userRepository.findName(email, password);
        dashboardlabel.setText(dashboardlabel.getText() + " " + name);

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
     DRangeChecksMonthFrom.setText(Integer.toString(monthscheckCombo.getSelectedIndex()+1));
        DRangeCheckMonthTo.setText(Integer.toString(monthscheckCombo.getSelectedIndex()+1));
    }//GEN-LAST:event_monthscheckComboActionPerformed

    private void MonthlyCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthlyCheckRBtnActionPerformed
        filterVisibelity(MonthlyCheckRBtn);
        String dayString = "1";
        String dayEndMonth = "30";
        String dayEndmonth = "31";
        int year = userRepository.getYear();
        String yearString = Integer.toString(year);
        if ((monthsDocCombo.getSelectedIndex() + 1) > 6) {
             DRangeChecksDayFrom.setText(dayString);
             DRangeChecksDayTo.setText(dayEndMonth);
             DRangeChecksYearFrom.setText(yearString);
             DRangeCheckYearTo.setText(yearString);
             
        } else {
              DRangeChecksDayFrom.setText(dayString);
             DRangeChecksDayTo.setText(dayEndmonth);
             DRangeChecksYearFrom.setText(yearString);
             DRangeCheckYearTo.setText(yearString);
        }
        
        
        
    }//GEN-LAST:event_MonthlyCheckRBtnActionPerformed

    private void weeklyCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyCheckRBtnActionPerformed
        weeklyCheckRBtn.isSelected();
         int day = userRepository.getToday();
        String dayString = Integer.toString(day);
        String dayTo = Integer.toString(day + 6);
        int month = userRepository.getMonth();
        String monthString = Integer.toString(month);
        int year = userRepository.getYear();
        String yearString = Integer.toString(year);
        
        DRangeChecksDayFrom.setText(dayString);
        DRangeChecksDayTo.setText(dayTo);
        DRangeChecksMonthFrom.setText(monthString);
        DRangeCheckMonthTo.setText(monthString);
        DRangeChecksYearFrom.setText(yearString);
        DRangeCheckYearTo.setText(yearString);
    }//GEN-LAST:event_weeklyCheckRBtnActionPerformed

    private void dailyCheckRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyCheckRBtnActionPerformed
        dailyCheckRBtn.isSelected();
          int day = userRepository.getToday();
       String dayString = Integer.toString(day);
       int month = userRepository.getMonth();
       String monthString = Integer.toString(month);
       int year = userRepository.getYear();
       String yearString = Integer.toString(year);
        DRangeChecksDayFrom.setText(dayString);
        DRangeChecksDayTo.setText(dayString);
        
        DRangeChecksMonthFrom.setText(monthString);
        DRangeCheckMonthTo.setText(monthString);
        
        DRangeChecksYearFrom.setText(yearString);
        DRangeCheckYearTo.setText(yearString);
        
        
    }//GEN-LAST:event_dailyCheckRBtnActionPerformed

    private void backshowDoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backshowDoc1ActionPerformed
        landPage(dashboard);
    }//GEN-LAST:event_backshowDoc1ActionPerformed

    private void ShowChecksbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowChecksbtnActionPerformed
        landPage(checksReport);

        if (!(Manager.checkDocList.isEmpty())) {
            Double weight = Accounting.calculateWeight();
            checkWeightLabel.setText(String.valueOf(weight));
        }


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
                String CheckfilterDfrom = DRangeChecksYearFrom.getText();
            } else {
                String CheckfilterMfrom = DRangeChecksMonthFrom.getText();
                String CheckfilterYfrom = DRangeChecksDayFrom.getText();

                String CheckfilterDTo = DRangeChecksDayTo.getText();
                String CheckfilterMTo = DRangeCheckMonthTo.getText();
                String CheckfilterYTo = DRangeCheckYearTo.getText();
            }
        }

    }//GEN-LAST:event_ShowChecksbtnActionPerformed

    private void groupDocSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupDocSubmitActionPerformed
landPage(addGroupDocs);
        addDocCounter++;
        countDoc.setText(String.valueOf(addDocCounter));
    }//GEN-LAST:event_groupDocSubmitActionPerformed

    private void addCheckBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCheckBack1ActionPerformed
landPage(addGroupDocs);

//        addCheckCounter++;
//        countCheck.setText(String.valueOf(addCheckCounter));




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
        String dayString = "1";
        String dayEndMonth = "30";
        String dayEndmonth = "31";
        int year = userRepository.getYear();
        String yearString = Integer.toString(year);
        if ((monthsDocCombo.getSelectedIndex() + 1) > 6) {
             DRangeDocsDayFrom.setText(dayString);
             DRangeDocsDayTo.setText(dayEndMonth);
             DRangeDocsYearFrom.setText(yearString);
             DRangeDocsYearTo.setText(yearString);
             
        } else {
             DRangeDocsDayFrom.setText(dayString);
             DRangeDocsDayTo.setText(dayEndmonth);
             DRangeDocsYearFrom.setText(yearString);
             DRangeDocsYearTo.setText(yearString);
        }
        
    }//GEN-LAST:event_MonthlyDocActionPerformed

    private void dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyActionPerformed
       
        int day = userRepository.getToday();
       String dayString = Integer.toString(day);
       int month = userRepository.getMonth();
       String monthString = Integer.toString(month);
       int year = userRepository.getYear();
       String yearString = Integer.toString(year);
        DRangeDocsDayFrom.setText(dayString);
        DRangeDocsDayTo.setText(dayString);
        
        DRangeDocsMonthFrom.setText(monthString);
        DRangeDocsmonthTo.setText(monthString);
        
        DRangeDocsYearFrom.setText(yearString);
        DRangeDocsYearTo.setText(yearString);
        
        
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
        landPage(chartPanel);
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
      chartFrame chartFrame= new chartFrame(NormalDoc.DayModel.generateDayModel(Manager.normalDocList));
//       this.setVisible(false);
            chartFrame.setSize(400, 400);
            chartFrame.setVisible(true);
 
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
            filterChecks = new FilterChecks(checkFilter, checkCostFromValue, checkcostToValue, statusTimeZoneFilteredCHECK);
        landPage(filteredChecks);
        } else if (TimeCheckRBtn.isSelected()) {
            int CheckfilterDfrom = Integer.parseInt(DRangeChecksDayFrom.getText());//integer 
            int CheckfilterMfrom = Integer.parseInt(DRangeChecksMonthFrom.getText());
            int CheckfilterYfrom = Integer.parseInt(DRangeChecksYearFrom.getText());
            DateNizek dateNZKFrom = new DateNizek(CheckfilterDfrom, CheckfilterMfrom, CheckfilterYfrom);
boolean validFrom=(Validator.dayFieldIsValid(DRangeChecksDayFrom.getText())
        &&Validator.monthIsValid(DRangeChecksMonthFrom.getText())&&
        Validator.yearIsValidDoc(DRangeChecksYearFrom.getText()));
            int CheckfilterDTo = Integer.parseInt(DRangeChecksDayTo.getText());
            int CheckfilterMTo = Integer.parseInt(DRangeCheckMonthTo.getText());
            int CheckfilterYTo = Integer.parseInt(DRangeCheckYearTo.getText());

            DateNizek dateNZKTo = new DateNizek(CheckfilterDTo, CheckfilterMTo, CheckfilterYTo);
boolean validTo=(Validator.dayFieldIsValid(DRangeChecksDayTo.getText())
        &&Validator.monthIsValid(DRangeCheckMonthTo.getText())&&
        Validator.yearIsValidDoc(DRangeCheckYearTo.getText()));
            filterChecks = new FilterChecks(checkFilter, dateNZKTo, dateNZKFrom, statusTimeZoneFilteredCHECK);
 if(!(validTo&&validFrom)){
  JOptionPane.showMessageDialog(addDocPanel, "فیلد های تاریخ را صحیح وارد کنید",
                "", JOptionPane.ERROR_MESSAGE);

landPage(showCheckpanel);
}else{
 
 landPage(filteredChecks);
 
 }
        } else if (payeeCheckRBtn.isSelected()) {

            String payeeFilterNameCheck = peopleCheckList.getSelectedItem().toString();

            filterChecks = new FilterChecks(checkFilter, payeeFilterNameCheck, statusTimeZoneFilteredCHECK);
landPage(filteredChecks);
        }        
        filteredCheckTable.setModel(filterChecks);

        
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
            filterDocs = new FilterDocs(docFilter, docCostFromValue, docCostToValue, statusTimeZoneFilteredNORMAL);
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
            filterDocs = new FilterDocs(docFilter, dateNZKTo, dateNZKFrom,  statusTimeZoneFilteredNORMAL);
if(!(validTo&&validFrom)){
  JOptionPane.showMessageDialog(addDocPanel, "فیلد های تاریخ را صحیح وارد کنید",
                "", JOptionPane.ERROR_MESSAGE);

landPage(showDocPanel);
}
        
        
        } else if (payeeDocRBtn.isSelected()) {

            String payeeFilterNameCheck = peopleDocList.getSelectedItem().toString();

            filterDocs = new FilterDocs(docFilter, payeeFilterNameCheck, statusTimeZoneFilteredNORMAL);

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
                Manager.removeFromList(check);
            }
    }//GEN-LAST:event_convertToDocActionPerformed
    }

    private void signInbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInbtnActionPerformed
        landPage(registerPanel);
        String emailInput = emailfieldLogin.getText();
        String passwordInput = passwordField.getText();

        Manager.addAdmin(new Admin(
                "Name",
                emailInput,
                passwordInput
        ));

    }//GEN-LAST:event_signInbtnActionPerformed


    private void jalaliBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jalaliBtnActionPerformed
       statusTimeZoneCHECK = true;
        checkRepo.setTimeZone(statusTimeZoneCHECK);
        checksTable.updateUI();
    }//GEN-LAST:event_jalaliBtnActionPerformed

    private void gregorianBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gregorianBtnActionPerformed
       statusTimeZoneCHECK = false;
        checkRepo.setTimeZone(statusTimeZoneCHECK);
         checksTable.updateUI();
        
    }//GEN-LAST:event_gregorianBtnActionPerformed

    private void jalaliNormalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jalaliNormalBtnActionPerformed
        statusTimeZoneNORMAL = true;
        docRepo.setStatus(statusTimeZoneNORMAL);
        docsTable.updateUI();
    }//GEN-LAST:event_jalaliNormalBtnActionPerformed

    private void gregorianNormalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gregorianNormalBtnActionPerformed
        statusTimeZoneCHECK = false;
        docRepo.setStatus(statusTimeZoneCHECK);
        docsTable.updateUI();
    }//GEN-LAST:event_gregorianNormalBtnActionPerformed

    private void addNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNameActionPerformed

    private void iranfilteredNormalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iranfilteredNormalBtnActionPerformed
        statusTimeZoneFilteredNORMAL = true;
        filterDocs.setStatus(statusTimeZoneFilteredNORMAL);
        filteredDocTable.updateUI();
    }//GEN-LAST:event_iranfilteredNormalBtnActionPerformed

    private void gmtFilteredNormalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gmtFilteredNormalBtnActionPerformed
        statusTimeZoneFilteredNORMAL= false;
        filterDocs.setStatus(statusTimeZoneFilteredNORMAL);
        filteredDocTable.updateUI();
    }//GEN-LAST:event_gmtFilteredNormalBtnActionPerformed

    private void iranFilteredCHECKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iranFilteredCHECKActionPerformed
        statusTimeZoneFilteredCHECK = true;
        filterChecks.setStatus(statusTimeZoneFilteredCHECK);
        filteredCheckTable.updateUI();
    }//GEN-LAST:event_iranFilteredCHECKActionPerformed

    private void gmtFilteredCHECKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gmtFilteredCHECKActionPerformed
       statusTimeZoneFilteredCHECK = false;
       filterChecks.setStatus(statusTimeZoneFilteredCHECK);
       filteredCheckTable.updateUI();
    }//GEN-LAST:event_gmtFilteredCHECKActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        String userNameInput = userNameRegister.getText().trim();
        String emailInput = emailRegister.getText().trim().toLowerCase();
        String passwordInput = passwordRegister.getText().trim().toLowerCase();
        
        Manager.addAdmin(new Admin(userNameInput, emailInput, passwordInput));
        System.out.println("Successful");
//        JOptionPane.showMessageDialog(addDocPanel, "کاربری با مشخصات ورودی شما یافت نشد",
//                "", JOptionPane.ERROR_MESSAGE);
        landPage(LoginPanel);
        
        
    }//GEN-LAST:event_registerBtnActionPerformed

    private void backToLoginPanelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToLoginPanelBtnActionPerformed
        landPage(LoginPanel);
    }//GEN-LAST:event_backToLoginPanelBtnActionPerformed

    private void weeklyDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyDocActionPerformed
        int day = userRepository.getToday();
        String dayString = Integer.toString(day);
        String dayTo = Integer.toString(day + 6);
        int month = userRepository.getMonth();
        String monthString = Integer.toString(month);
        int year = userRepository.getYear();
        String yearString = Integer.toString(year);
        
        DRangeDocsDayFrom.setText(dayString);
        DRangeDocsDayTo.setText(dayTo);
        DRangeDocsMonthFrom.setText(monthString);
        DRangeDocsmonthTo.setText(monthString);
        DRangeDocsYearFrom.setText(yearString);
        DRangeDocsYearTo.setText(yearString);
        
       
    }//GEN-LAST:event_weeklyDocActionPerformed

    private void DRangeChecksMonthFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DRangeChecksMonthFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DRangeChecksMonthFromActionPerformed

    private void DRangeCheckMonthToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DRangeCheckMonthToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DRangeCheckMonthToActionPerformed

    private void removeidTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeidTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeidTFActionPerformed

    private void okRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okRemoveBtnActionPerformed
        String id = removeidTF.getText();
        int idInt = Integer.parseInt(id);
        userRepository.removeFromNormalDocList(idInt);
        docsTable.updateUI();
    }//GEN-LAST:event_okRemoveBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String id = removeCheckidBTN.getText();
       int idInt = Integer.parseInt(id);
       userRepository.removeFromCheckDocList(idInt);
       checksTable.updateUI();
       double weight = Accounting.calculateWeight();
       System.out.println(weight);
       String weightString = Double.toString(weight);
       checkWeightLabel.setText(weightString);
      

    }//GEN-LAST:event_jButton3ActionPerformed

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
        chartPanel.setVisible(panel == chartPanel);
        tarazName.setVisible(panel == tarazName);
        LoginPanel.setVisible(panel == LoginPanel);
        dashboard.setVisible(panel == dashboard);
        addcheckPanel.setVisible(panel == addcheckPanel);
        stateChangePanel.setVisible(panel == stateChangePanel);
        showDocPanel.setVisible(panel == showDocPanel);
        addDocPanel.setVisible(panel == addDocPanel);
        addPeoplePanel.setVisible(panel == addPeoplePanel);
addGroupDocs.setVisible(panel==addGroupDocs);
        addCategoryPanel.setVisible(panel == addCategoryPanel);
        showCheckpanel.setVisible(panel == showCheckpanel);
        checksReport.setVisible(panel == checksReport);
        docsReport.setVisible(panel == docsReport);
        peopleReports.setVisible(panel == peopleReports);
        registerPanel.setVisible(panel == registerPanel);
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
                 DashboardMenu dashboard= new DashboardMenu();
               dashboard.setVisible(true);
               
         //       final CreditorChart chart = new CreditorChart();
         
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressField;
    private javax.swing.JTextField DRangeCheckMonthTo;
    private javax.swing.JTextField DRangeCheckYearTo;
    private javax.swing.JTextField DRangeChecksDayFrom;
    private javax.swing.JTextField DRangeChecksDayTo;
    private javax.swing.JTextField DRangeChecksMonthFrom;
    private javax.swing.JTextField DRangeChecksYearFrom;
    private javax.swing.JTextField DRangeDocsDayFrom;
    private javax.swing.JTextField DRangeDocsDayTo;
    private javax.swing.JTextField DRangeDocsMonthFrom;
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
    private javax.swing.JPanel addGroupDocs;
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
    private javax.swing.JButton backToLoginPanelBtn;
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
    private javax.swing.JButton chartBtn;
    private javax.swing.JPanel chartPanel;
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
    private javax.swing.JTextField emailRegister;
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
    private javax.swing.JButton gmtFilteredCHECK;
    private javax.swing.JButton gmtFilteredNormalBtn;
    private javax.swing.JButton gregorianBtn;
    private javax.swing.JButton gregorianNormalBtn;
    private javax.swing.JButton groupDocSubmit;

    private javax.swing.JButton iranFilteredCHECK;
    private javax.swing.JButton iranfilteredNormalBtn;

    public javax.swing.JTable groupedDoc;

    private javax.swing.JRadioButton isCashedBtn;
    private javax.swing.JToggleButton isCreditorToggle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jalaliBtn;
    private javax.swing.JButton jalaliNormalBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JComboBox<String> monthsDocCombo;
    private javax.swing.JComboBox<String> monthscheckCombo;
    private javax.swing.JButton okRemoveBtn;
    private javax.swing.JRadioButton partnerBtn;
    private javax.swing.JButton passWordRecovery;
    protected javax.swing.JTextField passwordField;
    private javax.swing.JTextField passwordRegister;
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
    private javax.swing.JButton registerBtn;
    private javax.swing.JButton registerChangeCheck;
    private javax.swing.JButton registerCheck;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JTextField removeCheckidBTN;
    private javax.swing.JTextField removeidTF;
    private javax.swing.JScrollPane scrollDoc;
    private javax.swing.JPanel showCheckpanel;
    private javax.swing.JPanel showDocPanel;
    private javax.swing.JButton showPeople;
    private javax.swing.JButton signInbtn;
    private javax.swing.JLabel sliderCheckLabel;
    private javax.swing.JPanel stateChangePanel;
    private javax.swing.JButton submitAll;
    private javax.swing.JButton submitDoc;
    private javax.swing.JButton tarazBtn;
    private javax.swing.JPanel tarazName;
    private javax.swing.ButtonGroup timeFilter;
    private javax.swing.JTextField userNameRegister;
    private javax.swing.JRadioButton weeklyCheckRBtn;
    private javax.swing.JRadioButton weeklyDoc;
    // End of variables declaration//GEN-END:variables

    void paintComponent(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
