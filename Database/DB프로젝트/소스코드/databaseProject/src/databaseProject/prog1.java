package databaseProject;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author JI
 *
 *
 */
public class prog1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("prog1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to close normal
		frame.setResizable(false); // can't control frame size

		PrimaryPanel primary = new PrimaryPanel();
		frame.getContentPane().add(primary);

		frame.pack();
		frame.setVisible(true);

	}// main()

}// App class

class PrimaryPanel extends JPanel {

	private JPanel mainPanel;
	private JPanel tempPanel;
	private JComboBox cmbMenu;
	private JComboBox adminCbMenu;
	private JComboBox userCbMenu;
	private String[] strMenu = { "Admin", "User" };
	private String[] showAdminMenu = { "campingcar", "rentCorp", "repairShop" };
	private String[] showUserMenu = { "rental", "repair", "customer", "prevUse" };
	private JButton btnSearch;
	private JButton btnFirst;
	private JButton btnSecond;
	private JButton btnThird;
	private JButton btnFourth;
	private JButton showButton;
	private JButton pickButton;
	private JScrollPane jScollPane;
	private JTable jTable;

	JTextField txtRentCorpID;
	JTextField txtCorpName;
	JTextField txtCity;
	JTextField txtKu;
	JTextField txtDong;
	JTextField txtCorpPhoneNum;
	JTextField txtCorpManagerName;
	JTextField txtCorpManagerMail;

	JTextField utxtRentCorpID;
	JTextField utxtCorpName;
	JTextField utxtCity;
	JTextField utxtKu;
	JTextField utxtDong;
	JTextField utxtCorpPhoneNum;
	JTextField utxtCorpManagerName;
	JTextField utxtCorpManagerMail;

	JTextField dtxtRentCorpID;

	JTextField txtCarRegtID;
	JTextField txtCampingcar_RentCorpID;
	JTextField txtCarName;
	JTextField txtCarNum;
	JTextField txtCarMaxPeopNum;
	JTextField txtCarImage;
	JTextField txtCarInfo;
	JTextField txtcarRentCost;
	JTextField txtCarRegtDate;

	JTextField utxtCarRegtID;
	JTextField utxtCampingcar_RentCorpID;
	JTextField utxtCarName;
	JTextField utxtCarNum;
	JTextField utxtCarMaxPeopNum;
	JTextField utxtCarImage;
	JTextField utxtCarInfo;
	JTextField utxtcarRentCost;
	JTextField utxtCarRegtDate;

	JTextField dtxtCarRegtID;

	JTextField txtLicenseID;
	JTextField txtCusName;
	JTextField txtCusPhoneNum;
	JTextField txtCusMail;

	JTextField utxtLicenseID;
	JTextField utxtCusName;
	JTextField utxtCusPhoneNum;
	JTextField utxtCusMail;

	JTextField dtxtLicenseID;

	JTextField txtRentalID;
	JTextField txtRental_CarRegtID;
	JTextField txtRental_LicenseID;
	JTextField txtRental_RentCompanyID;
	JTextField txtRentStartDate;
	JTextField txtRentPeriod;
	JTextField txtRentPrice;
	JTextField txtPaymentDue;
	JTextField txtEtcBillDetail;
	JTextField txtEtcBillPrice;

	JTextField utxtRentalID;
	JTextField utxtRental_CarRegtID;
	JTextField utxtRental_LicenseID;
	JTextField utxtRental_RentCompanyID;
	JTextField utxtRentStartDate;
	JTextField utxtRentPeriod;
	JTextField utxtRentPrice;
	JTextField utxtPaymentDue;
	JTextField utxtEtcBillDetail;
	JTextField utxtEtcBillPrice;

	JTextField dtxtRentalID;

	JTextField txtShopID;
	JTextField txtShopName;
	JTextField txtShopPhoneNum;
	JTextField txtShopManagerName;
	JTextField txtShopManagerMail;

	JTextField utxtShopID;
	JTextField utxtShopName;
	JTextField utxtShopPhoneNum;
	JTextField utxtShopManagerName;
	JTextField utxtShopManagerMail;

	JTextField dtxtShopID;

	JTextField txtRepairID;
	JTextField txtRepair_CarRegtID;
	JTextField txtRepair_ShopID;
	JTextField txtRepair_RentCompanyID;
	JTextField txtRepair_LicenseID;
	JTextField txtRepairHistory;
	JTextField txtRepairDate;
	JTextField txtRepairPrice;
	JTextField txtEtcRepairInfo;

	JTextField utxtRepairID;
	JTextField utxtRepair_CarRegtID;
	JTextField utxtRepair_ShopID;
	JTextField utxtRepair_RentCompanyID;
	JTextField utxtRepair_LicenseID;
	JTextField utxtRepairHistory;
	JTextField utxtRepairDate;
	JTextField utxtRepairPrice;
	JTextField utxtEtcRepairInfo;

	JTextField dtxtRepairID;

	JTextField txtPrevUseNo;
	JTextField txtPrevUse_LicenseID;
	JTextField txtPrevUse_CarRegtID;
	JTextField txtPrevUseDate;

	JTextField utxtPrevUseNo;
	JTextField utxtPrevUse_LicenseID;
	JTextField utxtPrevUse_CarRegtID;
	JTextField utxtPrevUseDate;

	JTextField dtxtPrevUseNo;

	private BtnListener btnL;

	private DatabaseConnect dbConnect;

	public PrimaryPanel() {
		// db connect
		dbConnect = new DatabaseConnect();

		// Listener
		btnL = new BtnListener();

		// primary panel
		setBackground(Color.white);
		setPreferredSize(new Dimension(1000, 640));
		setLayout(null);

		setPage();
	}

	public void setPage() {

		mainPanel = new JPanel();
		mainPanel.setBounds(100, 150, 800, 450);
		mainPanel.setBackground(new Color(245, 245, 245));
		mainPanel.setLayout(null);

		// combo box for choosing table
		cmbMenu = new JComboBox();
		for (String str : strMenu)
			cmbMenu.addItem(str);
		cmbMenu.setBounds(105, 105, 170, 40);
		cmbMenu.setFont(new Font("Verdana", Font.PLAIN, 18));
		add(cmbMenu);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(285, 105, 80, 40);
		btnSearch.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnSearch.addActionListener(btnL);
		add(btnSearch);

		btnFirst = new JButton("1");
		btnFirst.setBounds(375, 105, 45, 30);
		btnFirst.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnFirst.addActionListener(btnL);
		add(btnFirst);

		btnSecond = new JButton("2");
		btnSecond.setBounds(430, 105, 45, 30);
		btnSecond.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnSecond.addActionListener(btnL);
		add(btnSecond);

		btnThird = new JButton("3");
		btnThird.setBounds(485, 105, 45, 30);
		btnThird.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnThird.addActionListener(btnL);
		add(btnThird);

		btnFourth = new JButton("4");
		btnFourth.setBounds(540, 105, 45, 30);
		btnFourth.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnFourth.addActionListener(btnL);
		add(btnFourth);

		adminCbMenu = new JComboBox();
		for (String str : showAdminMenu)
			adminCbMenu.addItem(str);
		adminCbMenu.setBounds(600, 105, 130, 40);
		adminCbMenu.setFont(new Font("Verdana", Font.PLAIN, 18));
		add(adminCbMenu);

		adminCbMenu.setVisible(false);

		userCbMenu = new JComboBox();
		for (String str : showUserMenu)
			userCbMenu.addItem(str);
		userCbMenu.setBounds(600, 105, 130, 40);
		userCbMenu.setFont(new Font("Verdana", Font.PLAIN, 18));
		add(userCbMenu);
		userCbMenu.setVisible(false);

		showButton = new JButton("Show");
		showButton.setBounds(760, 105, 80, 35);
		showButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		showButton.addActionListener(btnL);
		add(showButton);

		pickButton = new JButton("Pick");
		pickButton.setBounds(760, 105, 80, 35);
		pickButton.setFont(new Font("Verdana", Font.PLAIN, 15));
		pickButton.addActionListener(btnL);
		add(pickButton);

		showButton.setVisible(false);
		pickButton.setVisible(false);

		add(mainPanel);
		setVisible(true);
	}

	private JPanel getAdminTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		userCbMenu.setVisible(false);
		adminCbMenu.setVisible(true);
		showButton.setVisible(true);
		/******* SELECT ********/

		// btnSelect
		JButton btnSelect1 = new JButton("Identify frequent maintenance customers");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Understand how many customers are using");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		return jPanel;
	}

	private JPanel getUserTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		adminCbMenu.setVisible(false);
		userCbMenu.setVisible(true);

		showButton.setVisible(true);

		/******* SELECT ********/

		// btnSelect
		JButton btnSelect1 = new JButton("Find a repairshop in the same city");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Find the average of car rent cost by the maximum number of passengers");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JButton btnSelect3 = new JButton("Find a cheap and unused camping car");
		btnSelect3.setBounds(100, 150, 550, 35);
		btnSelect3.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect3.addActionListener(btnL);
		jPanel.add(btnSelect3);

		return jPanel;
	}

	// insert / update / delete (campingcar)
	// getcampingcartable
	private JPanel getCampingcarTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		/******* INSERT ********/
		JLabel lbInsert = new JLabel("INSERT");
		lbInsert.setBounds(10, 0, 100, 40);
		lbInsert.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbInsert);

		// carRegtID
		JLabel lbCarRegtID = new JLabel("CarRegtID");
		lbCarRegtID.setBounds(10, 20, 200, 40);
		lbCarRegtID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCarRegtID);

		txtCarRegtID = new JTextField();
		txtCarRegtID.setBounds(130, 30, 60, 30);
		jPanel.add(txtCarRegtID);

		// Campingcar_RentCorpID
		JLabel lbCampingcar_RentCorpID = new JLabel("Campingcar_RentCorpID");
		lbCampingcar_RentCorpID.setBounds(200, 20, 200, 40);
		lbCampingcar_RentCorpID.setFont(new Font("Verdana", Font.PLAIN, 8));
		jPanel.add(lbCampingcar_RentCorpID);

		txtCampingcar_RentCorpID = new JTextField();
		txtCampingcar_RentCorpID.setBounds(320, 30, 60, 30);
		jPanel.add(txtCampingcar_RentCorpID);

		// carName
		JLabel lbCarName = new JLabel("CarName");
		lbCarName.setBounds(390, 20, 100, 40);
		lbCarName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCarName);

		txtCarName = new JTextField();
		txtCarName.setBounds(510, 30, 60, 30);
		jPanel.add(txtCarName);

		// carNum
		JLabel lbCarNum = new JLabel("CarNum");
		lbCarNum.setBounds(580, 20, 100, 40);
		lbCarNum.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCarNum);

		txtCarNum = new JTextField();
		txtCarNum.setBounds(700, 30, 60, 30);
		jPanel.add(txtCarNum);

		// carMaxPeopNum
		JLabel lbCarMaxPeopNum = new JLabel("CarMaxPeopNum");
		lbCarMaxPeopNum.setBounds(10, 60, 100, 40);
		lbCarMaxPeopNum.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCarMaxPeopNum);

		txtCarMaxPeopNum = new JTextField();
		txtCarMaxPeopNum.setBounds(130, 70, 60, 30);
		jPanel.add(txtCarMaxPeopNum);

		// carImage
		JLabel lbCarImage = new JLabel("CarImage");
		lbCarImage.setBounds(200, 60, 200, 40);
		lbCarImage.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCarImage);

		txtCarImage = new JTextField();
		txtCarImage.setBounds(320, 70, 60, 30);
		jPanel.add(txtCarImage);

		// carInfo
		JLabel lbCarInfo = new JLabel("CarInfo");
		lbCarInfo.setBounds(390, 60, 200, 40);
		lbCarInfo.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCarInfo);

		txtCarInfo = new JTextField();
		txtCarInfo.setBounds(510, 70, 60, 30);
		jPanel.add(txtCarInfo);

		// carRentCost
		JLabel lbCarRentCost = new JLabel("CarRentCost");
		lbCarRentCost.setBounds(580, 60, 200, 40);
		lbCarRentCost.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCarRentCost);

		txtcarRentCost = new JTextField();
		txtcarRentCost.setBounds(700, 70, 60, 30);
		jPanel.add(txtcarRentCost);

		// CarRegtDate
		JLabel lbCarRegtDate = new JLabel("CarRegtDate");
		lbCarRegtDate.setBounds(10, 110, 200, 40);
		lbCarRegtDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCarRegtDate);

		txtCarRegtDate = new JTextField();
		txtCarRegtDate.setBounds(130, 110, 60, 30);
		jPanel.add(txtCarRegtDate);

		// btnInsert
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(350, 110, 80, 35);
		btnInsert.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnInsert.addActionListener(btnL);
		jPanel.add(btnInsert);

		JLabel insertLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		insertLine.setBounds(10, 140, 800, 35);
		jPanel.add(insertLine);

		/******* UPDATE ********/
		// primary key와 foreign key 는 수정 불가
		JLabel lbUpdate = new JLabel("UPDATE");
		lbUpdate.setBounds(10, 160, 100, 40);
		lbUpdate.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbUpdate);

		// carRegtID
		JLabel ulbCarRegtID = new JLabel("CarRegtID");
		ulbCarRegtID.setBounds(10, 180, 100, 40);
		ulbCarRegtID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCarRegtID);

		utxtCarRegtID = new JTextField();
		utxtCarRegtID.setBounds(130, 190, 60, 30);
		jPanel.add(utxtCarRegtID);

		// Campingcar_RentCorpID
		JLabel ulbCampingcar_RentCorpID = new JLabel("Campingcar_RentCorpID");
		ulbCampingcar_RentCorpID.setBounds(200, 180, 100, 40);
		ulbCampingcar_RentCorpID.setFont(new Font("Verdana", Font.PLAIN, 8));
		jPanel.add(ulbCampingcar_RentCorpID);

		utxtCampingcar_RentCorpID = new JTextField();
		utxtCampingcar_RentCorpID.setBounds(320, 190, 60, 30);
		jPanel.add(utxtCampingcar_RentCorpID);

		// CarName
		JLabel ulbCarName = new JLabel("CarName");
		ulbCarName.setBounds(390, 180, 100, 40);
		ulbCarName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCarName);

		utxtCarName = new JTextField();
		utxtCarName.setBounds(510, 190, 60, 30);
		jPanel.add(utxtCarName);

		// CarNum
		JLabel ulbCarNum = new JLabel("CarNum");
		ulbCarNum.setBounds(580, 180, 100, 40);
		ulbCarNum.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCarNum);

		utxtCarNum = new JTextField();
		utxtCarNum.setBounds(700, 190, 60, 30);
		jPanel.add(utxtCarNum);

		// CarMaxPeopNum
		JLabel ulbCarMaxPeopNum = new JLabel("CarMaxPeopNum");
		ulbCarMaxPeopNum.setBounds(10, 220, 200, 40);
		ulbCarMaxPeopNum.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCarMaxPeopNum);

		utxtCarMaxPeopNum = new JTextField();
		utxtCarMaxPeopNum.setBounds(130, 230, 60, 30);
		jPanel.add(utxtCarMaxPeopNum);

		// CarImage
		JLabel ulbCarImage = new JLabel("CarImage");
		ulbCarImage.setBounds(200, 220, 200, 40);
		ulbCarImage.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCarImage);

		utxtCarImage = new JTextField();
		utxtCarImage.setBounds(320, 230, 60, 30);
		jPanel.add(utxtCarImage);

		// CarInfo
		JLabel ulbCarInfo = new JLabel("CarInfo");
		ulbCarInfo.setBounds(390, 220, 200, 40);
		ulbCarInfo.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCarInfo);

		utxtCarInfo = new JTextField();
		utxtCarInfo.setBounds(510, 230, 60, 30);
		jPanel.add(utxtCarInfo);

		// carRentCost
		JLabel ulbcarRentCost = new JLabel("carRentCost");
		ulbcarRentCost.setBounds(580, 220, 200, 40);
		ulbcarRentCost.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbcarRentCost);
		utxtcarRentCost = new JTextField();
		utxtcarRentCost.setBounds(700, 230, 60, 30);
		jPanel.add(utxtcarRentCost);

		// CarRegtDate
		JLabel ulbCarRegtDate = new JLabel("CarRegtDate");
		ulbCarRegtDate.setBounds(10, 270, 200, 40);
		ulbCarRegtDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCarRegtDate);
		utxtCarRegtDate = new JTextField();
		utxtCarRegtDate.setBounds(130, 270, 60, 30);
		jPanel.add(utxtCarRegtDate);

		// btnUpdate
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(350, 270, 90, 35);
		btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnUpdate.addActionListener(btnL);
		jPanel.add(btnUpdate);

		JLabel updateLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		updateLine.setBounds(10, 300, 800, 35);
		jPanel.add(updateLine);

		/******** DELETE ********/
		JLabel lbDelete = new JLabel("DELETE");
		lbDelete.setBounds(10, 320, 90, 40);
		lbDelete.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbDelete);

		// CarRegtID
		JLabel dlbCarRegtID = new JLabel("CarRegtID");
		dlbCarRegtID.setBounds(10, 350, 100, 40);
		dlbCarRegtID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(dlbCarRegtID);

		dtxtCarRegtID = new JTextField();
		dtxtCarRegtID.setBounds(130, 360, 60, 30);
		jPanel.add(dtxtCarRegtID);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(350, 390, 80, 35);
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.addActionListener(btnL);
		jPanel.add(btnDelete);

		return jPanel;
	}

	private JPanel getRentCorpTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		/******* INSERT ********/
		JLabel lbInsert = new JLabel("INSERT");
		lbInsert.setBounds(10, 0, 100, 40);
		lbInsert.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbInsert);

		// rentCorpID
		JLabel lbRentCorpID = new JLabel("rentCorpID");
		lbRentCorpID.setBounds(10, 20, 200, 40);
		lbRentCorpID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRentCorpID);

		txtRentCorpID = new JTextField();
		txtRentCorpID.setBounds(130, 30, 60, 30);
		jPanel.add(txtRentCorpID);

		// corpName
		JLabel lbCorpName = new JLabel("corpName");
		lbCorpName.setBounds(200, 20, 200, 40);
		lbCorpName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCorpName);

		txtCorpName = new JTextField();
		txtCorpName.setBounds(320, 30, 60, 30);
		jPanel.add(txtCorpName);

		// city
		JLabel lbCity = new JLabel("city");
		lbCity.setBounds(390, 20, 100, 40);
		lbCity.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCity);

		txtCity = new JTextField();
		txtCity.setBounds(510, 30, 60, 30);
		jPanel.add(txtCity);

		// ku
		JLabel lbKu = new JLabel("ku");
		lbKu.setBounds(580, 20, 100, 40);
		lbKu.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbKu);

		txtKu = new JTextField();
		txtKu.setBounds(700, 30, 60, 30);
		jPanel.add(txtKu);

		// dong
		JLabel lbDong = new JLabel("dong");
		lbDong.setBounds(10, 60, 100, 40);
		lbDong.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbDong);

		txtDong = new JTextField();
		txtDong.setBounds(130, 70, 60, 30);
		jPanel.add(txtDong);

		// CorpPhoneNum
		JLabel lbCorpPhoneNum = new JLabel("CorpPhoneNum");
		lbCorpPhoneNum.setBounds(200, 60, 200, 40);
		lbCorpPhoneNum.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCorpPhoneNum);

		txtCorpPhoneNum = new JTextField();
		txtCorpPhoneNum.setBounds(320, 70, 60, 30);
		jPanel.add(txtCorpPhoneNum);

		// corpManagerName
		JLabel lbCorpManagerName = new JLabel("corpManagerName");
		lbCorpManagerName.setBounds(390, 60, 200, 40);
		lbCorpManagerName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCorpManagerName);

		txtCorpManagerName = new JTextField();
		txtCorpManagerName.setBounds(510, 70, 60, 30);
		jPanel.add(txtCorpManagerName);

		// CorpManagerMail
		JLabel lbCorpManagerMail = new JLabel("CorpManagerMail");
		lbCorpManagerMail.setBounds(580, 60, 200, 40);
		lbCorpManagerMail.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCorpManagerMail);

		txtCorpManagerMail = new JTextField();
		txtCorpManagerMail.setBounds(700, 70, 60, 30);
		jPanel.add(txtCorpManagerMail);

		// btnInsert
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(350, 110, 80, 35);
		btnInsert.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnInsert.addActionListener(btnL);
		jPanel.add(btnInsert);

		JLabel insertLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		insertLine.setBounds(10, 140, 800, 35);
		jPanel.add(insertLine);

		/******* UPDATE ********/
		// primary key와 foreign key 는 수정 불가
		JLabel lbUpdate = new JLabel("UPDATE");
		lbUpdate.setBounds(10, 160, 100, 40);
		lbUpdate.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbUpdate);

		// rentCorpID
		JLabel ulbRentCorpID = new JLabel("rentCorpID");
		ulbRentCorpID.setBounds(10, 180, 100, 40);
		ulbRentCorpID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRentCorpID);

		utxtRentCorpID = new JTextField();
		utxtRentCorpID.setBounds(130, 190, 60, 30);
		jPanel.add(utxtRentCorpID);

		// corpName
		JLabel ulbCorpName = new JLabel("corpName");
		ulbCorpName.setBounds(200, 180, 100, 40);
		ulbCorpName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCorpName);

		utxtCorpName = new JTextField();
		utxtCorpName.setBounds(320, 190, 60, 30);
		jPanel.add(utxtCorpName);

		// city
		JLabel ulbCity = new JLabel("city");
		ulbCity.setBounds(390, 180, 100, 40);
		ulbCity.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCity);

		utxtCity = new JTextField();
		utxtCity.setBounds(510, 190, 60, 30);
		jPanel.add(utxtCity);

		// ku
		JLabel ulbKu = new JLabel("ku");
		ulbKu.setBounds(580, 180, 100, 40);
		ulbKu.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbKu);

		utxtKu = new JTextField();
		utxtKu.setBounds(700, 190, 60, 30);
		jPanel.add(utxtKu);

		// dong
		JLabel ulbDong = new JLabel("dong");
		ulbDong.setBounds(10, 220, 100, 40);
		ulbDong.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbDong);

		utxtDong = new JTextField();
		utxtDong.setBounds(130, 230, 60, 30);
		jPanel.add(utxtDong);

		// CorpPhoneNum
		JLabel ulbCorpPhoneNum = new JLabel("CorpPhoneNum");
		ulbCorpPhoneNum.setBounds(200, 220, 200, 40);
		ulbCorpPhoneNum.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCorpPhoneNum);

		utxtCorpPhoneNum = new JTextField();
		utxtCorpPhoneNum.setBounds(320, 230, 60, 30);
		jPanel.add(utxtCorpPhoneNum);

		// corpManagerName
		JLabel ulbCorpManagerName = new JLabel("corpManagerName");
		ulbCorpManagerName.setBounds(390, 220, 200, 40);
		ulbCorpManagerName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCorpManagerName);

		utxtCorpManagerName = new JTextField();
		utxtCorpManagerName.setBounds(510, 230, 60, 30);
		jPanel.add(utxtCorpManagerName);

		// CorpManagerMail
		JLabel ulbCorpManagerMail = new JLabel("CorpManagerMail");
		ulbCorpManagerMail.setBounds(580, 220, 200, 40);
		ulbCorpManagerMail.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCorpManagerMail);

		utxtCorpManagerMail = new JTextField();
		utxtCorpManagerMail.setBounds(700, 230, 60, 30);
		jPanel.add(utxtCorpManagerMail);

		// btnUpdate
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(350, 270, 90, 35);
		btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnUpdate.addActionListener(btnL);
		jPanel.add(btnUpdate);

		JLabel updateLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		updateLine.setBounds(10, 300, 800, 35);
		jPanel.add(updateLine);

		/******** DELETE ********/
		JLabel lbDelete = new JLabel("DELETE");
		lbDelete.setBounds(10, 320, 90, 40);
		lbDelete.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbDelete);

		// rentCorpID
		JLabel dlbRentCorpID = new JLabel("RentCorpID");
		dlbRentCorpID.setBounds(10, 350, 100, 40);
		dlbRentCorpID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(dlbRentCorpID);

		dtxtRentCorpID = new JTextField();
		dtxtRentCorpID.setBounds(150, 360, 60, 30);
		jPanel.add(dtxtRentCorpID);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(350, 390, 80, 35);
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.addActionListener(btnL);
		jPanel.add(btnDelete);

		return jPanel;
	}

	// customer
	private JPanel getCustomerTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		/******* INSERT ********/
		JLabel lbInsert = new JLabel("INSERT");
		lbInsert.setBounds(10, 0, 100, 40);
		lbInsert.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbInsert);

		// LicenseID
		JLabel lbLicenseID = new JLabel("LicenseID");
		lbLicenseID.setBounds(10, 20, 200, 40);
		lbLicenseID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbLicenseID);

		txtLicenseID = new JTextField();
		txtLicenseID.setBounds(130, 30, 60, 30);
		jPanel.add(txtLicenseID);

		// CusName
		JLabel lbCusName = new JLabel("CusName");
		lbCusName.setBounds(200, 20, 200, 40);
		lbCusName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCusName);

		txtCusName = new JTextField();
		txtCusName.setBounds(320, 30, 60, 30);
		jPanel.add(txtCusName);

		// city
		JLabel lbCity = new JLabel("city");
		lbCity.setBounds(390, 20, 100, 40);
		lbCity.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCity);

		txtCity = new JTextField();
		txtCity.setBounds(510, 30, 60, 30);
		jPanel.add(txtCity);

		// ku
		JLabel lbKu = new JLabel("ku");
		lbKu.setBounds(580, 20, 100, 40);
		lbKu.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbKu);

		txtKu = new JTextField();
		txtKu.setBounds(700, 30, 60, 30);
		jPanel.add(txtKu);

		// dong
		JLabel lbDong = new JLabel("dong");
		lbDong.setBounds(10, 60, 100, 40);
		lbDong.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbDong);

		txtDong = new JTextField();
		txtDong.setBounds(130, 70, 60, 30);
		jPanel.add(txtDong);

		// CusPhoneNum
		JLabel lbCusPhoneNum = new JLabel("CusPhoneNum");
		lbCusPhoneNum.setBounds(200, 60, 200, 40);
		lbCusPhoneNum.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCusPhoneNum);

		txtCusPhoneNum = new JTextField();
		txtCusPhoneNum.setBounds(320, 70, 60, 30);
		jPanel.add(txtCusPhoneNum);

		// CusMail
		JLabel lbCusMail = new JLabel("CusMail");
		lbCusMail.setBounds(390, 60, 200, 40);
		lbCusMail.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCusMail);

		txtCusMail = new JTextField();
		txtCusMail.setBounds(510, 70, 60, 30);
		jPanel.add(txtCusMail);

		// btnInsert
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(350, 110, 80, 35);
		btnInsert.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnInsert.addActionListener(btnL);
		jPanel.add(btnInsert);

		JLabel insertLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		insertLine.setBounds(10, 140, 800, 35);
		jPanel.add(insertLine);

		/******* UPDATE ********/
		// primary key와 foreign key 는 수정 불가
		JLabel lbUpdate = new JLabel("UPDATE");
		lbUpdate.setBounds(10, 160, 100, 40);
		lbUpdate.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbUpdate);

		// LicenseID
		JLabel ulbLicenseID = new JLabel("LicenseID");
		ulbLicenseID.setBounds(10, 180, 100, 40);
		ulbLicenseID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbLicenseID);

		utxtLicenseID = new JTextField();
		utxtLicenseID.setBounds(130, 190, 60, 30);
		jPanel.add(utxtLicenseID);

		// CusName
		JLabel ulbCusName = new JLabel("CusName");
		ulbCusName.setBounds(200, 180, 100, 40);
		ulbCusName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCusName);

		utxtCusName = new JTextField();
		utxtCusName.setBounds(320, 190, 60, 30);
		jPanel.add(utxtCusName);

		// city
		JLabel ulbCity = new JLabel("city");
		ulbCity.setBounds(390, 180, 100, 40);
		ulbCity.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCity);

		utxtCity = new JTextField();
		utxtCity.setBounds(510, 190, 60, 30);
		jPanel.add(utxtCity);

		// ku
		JLabel ulbKu = new JLabel("ku");
		ulbKu.setBounds(580, 180, 100, 40);
		ulbKu.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbKu);

		utxtKu = new JTextField();
		utxtKu.setBounds(700, 190, 60, 30);
		jPanel.add(utxtKu);

		// dong
		JLabel ulbDong = new JLabel("dong");
		ulbDong.setBounds(10, 220, 100, 40);
		ulbDong.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbDong);

		utxtDong = new JTextField();
		utxtDong.setBounds(130, 230, 60, 30);
		jPanel.add(utxtDong);

		// CusPhoneNum
		JLabel ulbCusPhoneNum = new JLabel("CusPhoneNum");
		ulbCusPhoneNum.setBounds(200, 220, 200, 40);
		ulbCusPhoneNum.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCusPhoneNum);

		utxtCusPhoneNum = new JTextField();
		utxtCusPhoneNum.setBounds(320, 230, 60, 30);
		jPanel.add(utxtCusPhoneNum);

		// CusMail
		JLabel ulbCusMail = new JLabel("CusMail");
		ulbCusMail.setBounds(390, 220, 200, 40);
		ulbCusMail.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCusMail);

		utxtCusMail = new JTextField();
		utxtCusMail.setBounds(510, 230, 60, 30);
		jPanel.add(utxtCusMail);

		// btnUpdate
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(350, 270, 90, 35);
		btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnUpdate.addActionListener(btnL);
		jPanel.add(btnUpdate);

		JLabel updateLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		updateLine.setBounds(10, 300, 800, 35);
		jPanel.add(updateLine);

		/******** DELETE ********/
		JLabel lbDelete = new JLabel("DELETE");
		lbDelete.setBounds(10, 320, 90, 40);
		lbDelete.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbDelete);

		// LicenseID
		JLabel dlbLicenseID = new JLabel("LicenseID");
		dlbLicenseID.setBounds(10, 350, 100, 40);
		dlbLicenseID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(dlbLicenseID);

		dtxtLicenseID = new JTextField();
		dtxtLicenseID.setBounds(150, 360, 60, 30);
		jPanel.add(dtxtLicenseID);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(350, 390, 80, 35);
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.addActionListener(btnL);
		jPanel.add(btnDelete);

		return jPanel;
	}

	// getrentaltable
	private JPanel getRentalTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		/******* INSERT ********/
		JLabel lbInsert = new JLabel("INSERT");
		lbInsert.setBounds(10, 0, 100, 40);
		lbInsert.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbInsert);

		// rentalID
		JLabel lbRentalID = new JLabel("RentalID");
		lbRentalID.setBounds(10, 20, 200, 40);
		lbRentalID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRentalID);

		txtRentalID = new JTextField();
		txtRentalID.setBounds(130, 30, 60, 30);
		jPanel.add(txtRentalID);

		// Rental_CarRegtID
		JLabel lbRental_CarRegtID = new JLabel("Rental_CarRegtID");
		lbRental_CarRegtID.setBounds(200, 20, 200, 40);
		lbRental_CarRegtID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRental_CarRegtID);

		txtRental_CarRegtID = new JTextField();
		txtRental_CarRegtID.setBounds(320, 30, 60, 30);
		jPanel.add(txtRental_CarRegtID);

		// Rental_LicenseID
		JLabel lbRental_LicenseID = new JLabel("Rental_LicenseID");
		lbRental_LicenseID.setBounds(390, 20, 100, 40);
		lbRental_LicenseID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRental_LicenseID);

		txtRental_LicenseID = new JTextField();
		txtRental_LicenseID.setBounds(510, 30, 60, 30);
		jPanel.add(txtRental_LicenseID);

		// Rental_RentCompanyID
		JLabel lbRental_RentCompanyID = new JLabel("Rental_RentCompanyID");
		lbRental_RentCompanyID.setBounds(580, 20, 100, 40);
		lbRental_RentCompanyID.setFont(new Font("Verdana", Font.PLAIN, 8));
		jPanel.add(lbRental_RentCompanyID);

		txtRental_RentCompanyID = new JTextField();
		txtRental_RentCompanyID.setBounds(700, 30, 60, 30);
		jPanel.add(txtRental_RentCompanyID);

		// RentStartDate
		JLabel lbRentStartDate = new JLabel("RentStartDate");
		lbRentStartDate.setBounds(10, 60, 100, 40);
		lbRentStartDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRentStartDate);

		txtRentStartDate = new JTextField();
		txtRentStartDate.setBounds(130, 70, 60, 30);
		jPanel.add(txtRentStartDate);

		// RentPeriod
		JLabel lbRentPeriod = new JLabel("RentPeriod");
		lbRentPeriod.setBounds(200, 60, 200, 40);
		lbRentPeriod.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRentPeriod);

		txtRentPeriod = new JTextField();
		txtRentPeriod.setBounds(320, 70, 60, 30);
		jPanel.add(txtRentPeriod);

		// RentPrice
		JLabel lbRentPrice = new JLabel("RentPrice");
		lbRentPrice.setBounds(390, 60, 200, 40);
		lbRentPrice.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRentPrice);

		txtRentPrice = new JTextField();
		txtRentPrice.setBounds(510, 70, 60, 30);
		jPanel.add(txtRentPrice);

		// PaymentDue
		JLabel lbPaymentDue = new JLabel("PaymentDue");
		lbPaymentDue.setBounds(580, 60, 200, 40);
		lbPaymentDue.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbPaymentDue);

		txtPaymentDue = new JTextField();
		txtPaymentDue.setBounds(700, 70, 60, 30);
		jPanel.add(txtPaymentDue);

		// EtcBillDetail
		JLabel lbEtcBillDetail = new JLabel("EtcBillDetail");
		lbEtcBillDetail.setBounds(10, 110, 200, 40);
		lbEtcBillDetail.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbEtcBillDetail);

		txtEtcBillDetail = new JTextField();
		txtEtcBillDetail.setBounds(130, 120, 60, 30);
		jPanel.add(txtEtcBillDetail);

		// EtcBillPrice
		JLabel lbEtcBillPrice = new JLabel("EtcBillPrice");
		lbEtcBillPrice.setBounds(580, 110, 200, 40);
		lbEtcBillPrice.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbEtcBillPrice);

		txtEtcBillPrice = new JTextField();
		txtEtcBillPrice.setBounds(700, 120, 60, 30);
		jPanel.add(txtEtcBillPrice);

		// btnInsert
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(350, 110, 80, 35);
		btnInsert.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnInsert.addActionListener(btnL);
		jPanel.add(btnInsert);

		JLabel insertLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		insertLine.setBounds(10, 140, 800, 35);
		jPanel.add(insertLine);

		/******* UPDATE ********/
		// primary key와 foreign key 는 수정 불가
		JLabel lbUpdate = new JLabel("UPDATE");
		lbUpdate.setBounds(10, 160, 100, 40);
		lbUpdate.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbUpdate);

		// RentalID
		JLabel ulbRentalID = new JLabel("RentalID");
		ulbRentalID.setBounds(10, 180, 100, 40);
		ulbRentalID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRentalID);

		utxtRentalID = new JTextField();
		utxtRentalID.setBounds(130, 190, 60, 30);
		jPanel.add(utxtRentalID);

		// Rental_CarRegtID
		JLabel ulbRental_CarRegtID = new JLabel("Rental_CarRegtID");
		ulbRental_CarRegtID.setBounds(200, 180, 100, 40);
		ulbRental_CarRegtID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRental_CarRegtID);

		utxtRental_CarRegtID = new JTextField();
		utxtRental_CarRegtID.setBounds(320, 190, 60, 30);
		jPanel.add(utxtRental_CarRegtID);

		// Rental_LicenseID
		JLabel ulbRental_LicenseID = new JLabel("Rental_LicenseID");
		ulbRental_LicenseID.setBounds(390, 180, 100, 40);
		ulbRental_LicenseID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRental_LicenseID);

		utxtRental_LicenseID = new JTextField();
		utxtRental_LicenseID.setBounds(510, 190, 60, 30);
		jPanel.add(utxtRental_LicenseID);

		// Rental_RentCompanyID
		JLabel ulbRental_RentCompanyID = new JLabel("Rental_RentCompanyID");
		ulbRental_RentCompanyID.setBounds(580, 180, 100, 40);
		ulbRental_RentCompanyID.setFont(new Font("Verdana", Font.PLAIN, 8));
		jPanel.add(ulbRental_RentCompanyID);

		utxtRental_RentCompanyID = new JTextField();
		utxtRental_RentCompanyID.setBounds(700, 190, 60, 30);
		jPanel.add(utxtRental_RentCompanyID);

		// RentStartDate
		JLabel ulbRentStartDate = new JLabel("RentStartDate");
		ulbRentStartDate.setBounds(10, 220, 100, 40);
		ulbRentStartDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRentStartDate);

		utxtRentStartDate = new JTextField();
		utxtRentStartDate.setBounds(130, 230, 60, 30);
		jPanel.add(utxtRentStartDate);

		// RentPeriod
		JLabel ulbRentPeriod = new JLabel("RentPeriod");
		ulbRentPeriod.setBounds(200, 220, 200, 40);
		ulbRentPeriod.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRentPeriod);

		utxtRentPeriod = new JTextField();
		utxtRentPeriod.setBounds(320, 230, 60, 30);
		jPanel.add(utxtRentPeriod);

		// RentPrice
		JLabel ulbRentPrice = new JLabel("RentPrice");
		ulbRentPrice.setBounds(390, 220, 200, 40);
		ulbRentPrice.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRentPrice);

		utxtRentPrice = new JTextField();
		utxtRentPrice.setBounds(510, 230, 60, 30);
		jPanel.add(utxtRentPrice);

		// PaymentDue
		JLabel ulbPaymentDue = new JLabel("PaymentDue");
		ulbPaymentDue.setBounds(580, 220, 200, 40);
		ulbPaymentDue.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbPaymentDue);

		utxtPaymentDue = new JTextField();
		utxtPaymentDue.setBounds(700, 230, 60, 30);
		jPanel.add(utxtPaymentDue);

		// EtcBillDetail
		JLabel ulbEtcBillDetail = new JLabel("EtcBillDetail");
		ulbEtcBillDetail.setBounds(10, 270, 200, 40);
		ulbEtcBillDetail.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbEtcBillDetail);

		utxtEtcBillDetail = new JTextField();
		utxtEtcBillDetail.setBounds(130, 280, 60, 30);
		jPanel.add(utxtEtcBillDetail);

		// EtcBillPrice
		JLabel ulbEtcBillPrice = new JLabel("EtcBillPrice");
		ulbEtcBillPrice.setBounds(580, 270, 200, 40);
		ulbEtcBillPrice.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbEtcBillPrice);

		utxtEtcBillPrice = new JTextField();
		utxtEtcBillPrice.setBounds(700, 280, 60, 30);
		jPanel.add(utxtEtcBillPrice);

		// btnUpdate
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(350, 270, 90, 35);
		btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnUpdate.addActionListener(btnL);
		jPanel.add(btnUpdate);

		JLabel updateLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		updateLine.setBounds(10, 300, 800, 35);
		jPanel.add(updateLine);

		/******** DELETE ********/
		JLabel lbDelete = new JLabel("DELETE");
		lbDelete.setBounds(10, 320, 90, 40);
		lbDelete.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbDelete);

		// RentalID
		JLabel dlbRentalID = new JLabel("RentalID");
		dlbRentalID.setBounds(10, 350, 100, 40);
		dlbRentalID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(dlbRentalID);

		dtxtRentalID = new JTextField();
		dtxtRentalID.setBounds(150, 360, 60, 30);
		jPanel.add(dtxtRentalID);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(350, 390, 80, 35);
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.addActionListener(btnL);
		jPanel.add(btnDelete);

		return jPanel;
	}

	private JPanel getRepairShopTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		/******* INSERT ********/
		JLabel lbInsert = new JLabel("INSERT");
		lbInsert.setBounds(10, 0, 100, 40);
		lbInsert.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbInsert);

		// ShopID
		JLabel lbShopID = new JLabel("ShopID");
		lbShopID.setBounds(10, 20, 200, 40);
		lbShopID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbShopID);

		txtShopID = new JTextField();
		txtShopID.setBounds(130, 30, 60, 30);
		jPanel.add(txtShopID);

		// ShopName
		JLabel lbShopName = new JLabel("ShopName");
		lbShopName.setBounds(200, 20, 200, 40);
		lbShopName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbShopName);

		txtShopName = new JTextField();
		txtShopName.setBounds(320, 30, 60, 30);
		jPanel.add(txtShopName);

		// City
		JLabel lbCity = new JLabel("City");
		lbCity.setBounds(390, 20, 100, 40);
		lbCity.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbCity);

		txtCity = new JTextField();
		txtCity.setBounds(510, 30, 60, 30);
		jPanel.add(txtCity);

		// Ku
		JLabel lbKu = new JLabel("Ku");
		lbKu.setBounds(580, 20, 100, 40);
		lbKu.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbKu);

		txtKu = new JTextField();
		txtKu.setBounds(700, 30, 60, 30);
		jPanel.add(txtKu);

		// Dong
		JLabel lbDong = new JLabel("Dong");
		lbDong.setBounds(10, 60, 100, 40);
		lbDong.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbDong);

		txtDong = new JTextField();
		txtDong.setBounds(130, 70, 60, 30);
		jPanel.add(txtDong);

		// ShopPhoneNum
		JLabel lbShopPhoneNum = new JLabel("ShopPhoneNum");
		lbShopPhoneNum.setBounds(200, 60, 200, 40);
		lbShopPhoneNum.setFont(new Font("Verdana", Font.PLAIN, 10));
		jPanel.add(lbShopPhoneNum);

		txtShopPhoneNum = new JTextField();
		txtShopPhoneNum.setBounds(320, 70, 60, 30);
		jPanel.add(txtShopPhoneNum);

		// ShopManagerName
		JLabel lbShopManagerName = new JLabel("ShopManagerName");
		lbShopManagerName.setBounds(390, 60, 200, 40);
		lbShopManagerName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbShopManagerName);

		txtShopManagerName = new JTextField();
		txtShopManagerName.setBounds(510, 70, 60, 30);
		jPanel.add(txtShopManagerName);

		// ShopManagerMail
		JLabel lbShopManagerMail = new JLabel("ShopManagerMail");
		lbShopManagerMail.setBounds(580, 60, 200, 40);
		lbShopManagerMail.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbShopManagerMail);

		txtShopManagerMail = new JTextField();
		txtShopManagerMail.setBounds(700, 70, 60, 30);
		jPanel.add(txtShopManagerMail);

		// btnInsert
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(350, 110, 80, 35);
		btnInsert.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnInsert.addActionListener(btnL);
		jPanel.add(btnInsert);

		JLabel insertLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		insertLine.setBounds(10, 140, 800, 35);
		jPanel.add(insertLine);

		/******* UPDATE ********/
		// primary key와 foreign key 는 수정 불가
		JLabel lbUpdate = new JLabel("UPDATE");
		lbUpdate.setBounds(10, 160, 100, 40);
		lbUpdate.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbUpdate);

		// ShopID
		JLabel ulbShopID = new JLabel("ShopID");
		ulbShopID.setBounds(10, 180, 100, 40);
		ulbShopID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbShopID);

		utxtShopID = new JTextField();
		utxtShopID.setBounds(130, 190, 60, 30);
		jPanel.add(utxtShopID);

		// ShopName
		JLabel ulbShopName = new JLabel("ShopName");
		ulbShopName.setBounds(200, 180, 100, 40);
		ulbShopName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbShopName);

		utxtShopName = new JTextField();
		utxtShopName.setBounds(320, 190, 60, 30);
		jPanel.add(utxtShopName);

		// City
		JLabel ulbCity = new JLabel("City");
		ulbCity.setBounds(390, 180, 100, 40);
		ulbCity.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbCity);

		utxtCity = new JTextField();
		utxtCity.setBounds(510, 190, 60, 30);
		jPanel.add(utxtCity);

		// Ku
		JLabel ulbKu = new JLabel("Ku");
		ulbKu.setBounds(580, 180, 100, 40);
		ulbKu.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbKu);

		utxtKu = new JTextField();
		utxtKu.setBounds(700, 190, 60, 30);
		jPanel.add(utxtKu);

		// Dong
		JLabel ulbDong = new JLabel("Dong");
		ulbDong.setBounds(10, 220, 100, 40);
		ulbDong.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbDong);

		utxtDong = new JTextField();
		utxtDong.setBounds(130, 230, 60, 30);
		jPanel.add(utxtDong);

		// ShopPhoneNum
		JLabel ulbShopPhoneNum = new JLabel("ShopPhoneNum");
		ulbShopPhoneNum.setBounds(200, 220, 200, 40);
		ulbShopPhoneNum.setFont(new Font("Verdana", Font.PLAIN, 10));
		jPanel.add(ulbShopPhoneNum);

		utxtShopPhoneNum = new JTextField();
		utxtShopPhoneNum.setBounds(320, 230, 60, 30);
		jPanel.add(utxtShopPhoneNum);

		// ShopManagerName
		JLabel ulbShopManagerName = new JLabel("ShopManagerName");
		ulbShopManagerName.setBounds(390, 220, 200, 40);
		ulbShopManagerName.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbShopManagerName);

		utxtShopManagerName = new JTextField();
		utxtShopManagerName.setBounds(510, 230, 60, 30);
		jPanel.add(utxtShopManagerName);

		// ShopManagerMail
		JLabel ulbShopManagerMail = new JLabel("ShopManagerMail");
		ulbShopManagerMail.setBounds(580, 220, 200, 40);
		ulbShopManagerMail.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbShopManagerMail);

		utxtShopManagerMail = new JTextField();
		utxtShopManagerMail.setBounds(700, 230, 60, 30);
		jPanel.add(utxtShopManagerMail);

		// btnUpdate
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(350, 270, 90, 35);
		btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnUpdate.addActionListener(btnL);
		jPanel.add(btnUpdate);

		JLabel updateLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		updateLine.setBounds(10, 300, 800, 35);
		jPanel.add(updateLine);

		/******** DELETE ********/
		JLabel lbDelete = new JLabel("DELETE");
		lbDelete.setBounds(10, 320, 90, 40);
		lbDelete.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbDelete);

		// ShopID
		JLabel dlbShopID = new JLabel("ShopID");
		dlbShopID.setBounds(10, 350, 100, 40);
		dlbShopID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(dlbShopID);

		dtxtShopID = new JTextField();
		dtxtShopID.setBounds(150, 360, 60, 30);
		jPanel.add(dtxtShopID);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(350, 390, 80, 35);
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.addActionListener(btnL);
		jPanel.add(btnDelete);

		return jPanel;
	}

	// getrepairtable
	private JPanel getRepairTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		/******* INSERT ********/
		JLabel lbInsert = new JLabel("INSERT");
		lbInsert.setBounds(10, 0, 100, 40);
		lbInsert.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbInsert);

		// RepairID
		JLabel lbRepairID = new JLabel("RepairID");
		lbRepairID.setBounds(10, 20, 200, 40);
		lbRepairID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRepairID);

		txtRepairID = new JTextField();
		txtRepairID.setBounds(130, 30, 60, 30);
		jPanel.add(txtRepairID);

		// Repair_CarRegtID
		JLabel lbRepair_CarRegtID = new JLabel("Repair_CarRegtID");
		lbRepair_CarRegtID.setBounds(200, 20, 200, 40);
		lbRepair_CarRegtID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRepair_CarRegtID);

		txtRepair_CarRegtID = new JTextField();
		txtRepair_CarRegtID.setBounds(320, 30, 60, 30);
		jPanel.add(txtRepair_CarRegtID);

		// Repair_ShopID
		JLabel lbRepair_ShopID = new JLabel("Repair_ShopID");
		lbRepair_ShopID.setBounds(390, 20, 100, 40);
		lbRepair_ShopID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRepair_ShopID);

		txtRepair_ShopID = new JTextField();
		txtRepair_ShopID.setBounds(510, 30, 60, 30);
		jPanel.add(txtRepair_ShopID);

		// Repair_RentCompanyID
		JLabel lbRepair_RentCompanyID = new JLabel("Repair_RentCompanyID");
		lbRepair_RentCompanyID.setBounds(580, 20, 100, 40);
		lbRepair_RentCompanyID.setFont(new Font("Verdana", Font.PLAIN, 8));
		jPanel.add(lbRepair_RentCompanyID);

		txtRepair_RentCompanyID = new JTextField();
		txtRepair_RentCompanyID.setBounds(700, 30, 60, 30);
		jPanel.add(txtRepair_RentCompanyID);

		// Repair_LicenseID
		JLabel lbRepair_LicenseID = new JLabel("Repair_LicenseID");
		lbRepair_LicenseID.setBounds(10, 60, 100, 40);
		lbRepair_LicenseID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRepair_LicenseID);

		txtRepair_LicenseID = new JTextField();
		txtRepair_LicenseID.setBounds(130, 70, 60, 30);
		jPanel.add(txtRepair_LicenseID);

		// RepairHistory
		JLabel lbRepairHistory = new JLabel("RepairHistory");
		lbRepairHistory.setBounds(200, 60, 200, 40);
		lbRepairHistory.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRepairHistory);

		txtRepairHistory = new JTextField();
		txtRepairHistory.setBounds(320, 70, 60, 30);
		jPanel.add(txtRepairHistory);

		// RepairDate
		JLabel lbRepairDate = new JLabel("RepairDate");
		lbRepairDate.setBounds(390, 60, 200, 40);
		lbRepairDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRepairDate);

		txtRepairDate = new JTextField();
		txtRepairDate.setBounds(510, 70, 60, 30);
		jPanel.add(txtRepairDate);

		// RepairPrice
		JLabel lbRepairPrice = new JLabel("RepairPrice");
		lbRepairPrice.setBounds(580, 60, 200, 40);
		lbRepairPrice.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbRepairPrice);

		txtRepairPrice = new JTextField();
		txtRepairPrice.setBounds(700, 70, 60, 30);
		jPanel.add(txtRepairPrice);

		// PaymentDue
		JLabel lbPaymentDue = new JLabel("PaymentDue");
		lbPaymentDue.setBounds(10, 110, 200, 40);
		lbPaymentDue.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbPaymentDue);

		txtPaymentDue = new JTextField();
		txtPaymentDue.setBounds(130, 120, 60, 30);
		jPanel.add(txtPaymentDue);

		// EtcRepairInfo
		JLabel lbEtcRepairInfo = new JLabel("EtcRepairInfo");
		lbEtcRepairInfo.setBounds(580, 110, 200, 40);
		lbEtcRepairInfo.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbEtcRepairInfo);

		txtEtcRepairInfo = new JTextField();
		txtEtcRepairInfo.setBounds(700, 120, 60, 30);
		jPanel.add(txtEtcRepairInfo);

		// btnInsert
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(350, 110, 80, 35);
		btnInsert.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnInsert.addActionListener(btnL);
		jPanel.add(btnInsert);

		JLabel insertLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		insertLine.setBounds(10, 140, 800, 35);
		jPanel.add(insertLine);

		/******* UPDATE ********/
		// primary key와 foreign key 는 수정 불가
		JLabel lbUpdate = new JLabel("UPDATE");
		lbUpdate.setBounds(10, 160, 100, 40);
		lbUpdate.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbUpdate);

		// RepairID
		JLabel ulbRepairID = new JLabel("RepairID");
		ulbRepairID.setBounds(10, 180, 100, 40);
		ulbRepairID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRepairID);

		utxtRepairID = new JTextField();
		utxtRepairID.setBounds(130, 190, 60, 30);
		jPanel.add(utxtRepairID);

		// Repair_CarRegtID
		JLabel ulbRepair_CarRegtID = new JLabel("Repair_CarRegtID");
		ulbRepair_CarRegtID.setBounds(200, 180, 100, 40);
		ulbRepair_CarRegtID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRepair_CarRegtID);

		utxtRepair_CarRegtID = new JTextField();
		utxtRepair_CarRegtID.setBounds(320, 190, 60, 30);
		jPanel.add(utxtRepair_CarRegtID);

		// Repair_ShopID
		JLabel ulbRepair_ShopID = new JLabel("Repair_ShopID");
		ulbRepair_ShopID.setBounds(390, 180, 100, 40);
		ulbRepair_ShopID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRepair_ShopID);

		utxtRepair_ShopID = new JTextField();
		utxtRepair_ShopID.setBounds(510, 190, 60, 30);
		jPanel.add(utxtRepair_ShopID);

		// Repair_RentCompanyID
		JLabel ulbRepair_RentCompanyID = new JLabel("Repair_RentCompanyID");
		ulbRepair_RentCompanyID.setBounds(580, 180, 100, 40);
		ulbRepair_RentCompanyID.setFont(new Font("Verdana", Font.PLAIN, 8));
		jPanel.add(ulbRepair_RentCompanyID);

		utxtRepair_RentCompanyID = new JTextField();
		utxtRepair_RentCompanyID.setBounds(700, 190, 60, 30);
		jPanel.add(utxtRepair_RentCompanyID);

		// Repair_LicenseID
		JLabel ulbRepair_LicenseID = new JLabel("Repair_LicenseID");
		ulbRepair_LicenseID.setBounds(10, 220, 100, 40);
		ulbRepair_LicenseID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRepair_LicenseID);

		utxtRepair_LicenseID = new JTextField();
		utxtRepair_LicenseID.setBounds(130, 230, 60, 30);
		jPanel.add(utxtRepair_LicenseID);

		// RepairHistory
		JLabel ulbRepairHistory = new JLabel("RepairHistory");
		ulbRepairHistory.setBounds(200, 220, 200, 40);
		ulbRepairHistory.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRepairHistory);

		utxtRepairHistory = new JTextField();
		utxtRepairHistory.setBounds(320, 230, 60, 30);
		jPanel.add(utxtRepairHistory);

		// RepairDate
		JLabel ulbRepairDate = new JLabel("RepairDate");
		ulbRepairDate.setBounds(390, 220, 200, 40);
		ulbRepairDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRepairDate);

		utxtRepairDate = new JTextField();
		utxtRepairDate.setBounds(510, 230, 60, 30);
		jPanel.add(utxtRepairDate);

		// RepairPrice
		JLabel ulbRepairPrice = new JLabel("RepairPrice");
		ulbRepairPrice.setBounds(580, 220, 200, 40);
		ulbRepairPrice.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbRepairPrice);

		utxtRepairPrice = new JTextField();
		utxtRepairPrice.setBounds(700, 230, 60, 30);
		jPanel.add(utxtRepairPrice);

		// PaymentDue
		JLabel ulbPaymentDue = new JLabel("PaymentDue");
		ulbPaymentDue.setBounds(10, 270, 200, 40);
		ulbPaymentDue.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbPaymentDue);

		utxtPaymentDue = new JTextField();
		utxtPaymentDue.setBounds(130, 280, 60, 30);
		jPanel.add(utxtPaymentDue);

		// EtcRepairInfo
		JLabel ulbEtcRepairInfo = new JLabel("EtcRepairInfo");
		ulbEtcRepairInfo.setBounds(580, 270, 200, 40);
		ulbEtcRepairInfo.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbEtcRepairInfo);

		utxtEtcRepairInfo = new JTextField();
		utxtEtcRepairInfo.setBounds(700, 280, 60, 30);
		jPanel.add(utxtEtcRepairInfo);

		// btnUpdate
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(350, 270, 90, 35);
		btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnUpdate.addActionListener(btnL);
		jPanel.add(btnUpdate);

		JLabel updateLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		updateLine.setBounds(10, 300, 800, 35);
		jPanel.add(updateLine);

		/******** DELETE ********/
		JLabel lbDelete = new JLabel("DELETE");
		lbDelete.setBounds(10, 320, 90, 40);
		lbDelete.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbDelete);

		// RepairID
		JLabel dlbRepairID = new JLabel("RepairID");
		dlbRepairID.setBounds(10, 350, 100, 40);
		dlbRepairID.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(dlbRepairID);

		dtxtRepairID = new JTextField();
		dtxtRepairID.setBounds(150, 360, 60, 30);
		jPanel.add(dtxtRepairID);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(350, 390, 80, 35);
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.addActionListener(btnL);
		jPanel.add(btnDelete);

		return jPanel;
	} // RepairShop

	private JPanel getPrevUseTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		/******* INSERT ********/
		JLabel lbInsert = new JLabel("INSERT");
		lbInsert.setBounds(10, 0, 100, 40);
		lbInsert.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbInsert);

		// PrevUseNo
		JLabel lbPrevUseNo = new JLabel("PrevUseNo");
		lbPrevUseNo.setBounds(10, 20, 200, 40);
		lbPrevUseNo.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbPrevUseNo);

		txtPrevUseNo = new JTextField();
		txtPrevUseNo.setBounds(130, 30, 60, 30);
		jPanel.add(txtPrevUseNo);

		// PrevUse_LicenseID
		JLabel lbPrevUse_LicenseID = new JLabel("PrevUse_LicenseID");
		lbPrevUse_LicenseID.setBounds(200, 20, 200, 40);
		lbPrevUse_LicenseID.setFont(new Font("Verdana", Font.PLAIN, 10));
		jPanel.add(lbPrevUse_LicenseID);

		txtPrevUse_LicenseID = new JTextField();
		txtPrevUse_LicenseID.setBounds(320, 30, 60, 30);
		jPanel.add(txtPrevUse_LicenseID);

		// PrevUse_CarRegtID
		JLabel lbPrevUse_CarRegtID = new JLabel("PrevUse_CarRegtID");
		lbPrevUse_CarRegtID.setBounds(390, 20, 100, 40);
		lbPrevUse_CarRegtID.setFont(new Font("Verdana", Font.PLAIN, 8));
		jPanel.add(lbPrevUse_CarRegtID);

		txtPrevUse_CarRegtID = new JTextField();
		txtPrevUse_CarRegtID.setBounds(510, 30, 60, 30);
		jPanel.add(txtPrevUse_CarRegtID);

		// PrevUseDate
		JLabel lbPrevUseDate = new JLabel("PrevUseDate");
		lbPrevUseDate.setBounds(580, 20, 100, 40);
		lbPrevUseDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(lbPrevUseDate);

		txtPrevUseDate = new JTextField();
		txtPrevUseDate.setBounds(700, 30, 60, 30);
		jPanel.add(txtPrevUseDate);

		// btnInsert
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(350, 110, 80, 35);
		btnInsert.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnInsert.addActionListener(btnL);
		jPanel.add(btnInsert);

		JLabel insertLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		insertLine.setBounds(10, 140, 800, 35);
		jPanel.add(insertLine);

		/******* UPDATE ********/
		// primary key와 foreign key 는 수정 불가
		JLabel lbUpdate = new JLabel("UPDATE");
		lbUpdate.setBounds(10, 160, 100, 40);
		lbUpdate.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbUpdate);

		// PrevUseNo
		JLabel ulbPrevUseNo = new JLabel("PrevUseNo");
		ulbPrevUseNo.setBounds(10, 180, 100, 40);
		ulbPrevUseNo.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbPrevUseNo);

		utxtPrevUseNo = new JTextField();
		utxtPrevUseNo.setBounds(130, 190, 60, 30);
		jPanel.add(utxtPrevUseNo);

		// PrevUse_LicenseID
		JLabel ulbPrevUse_LicenseID = new JLabel("PrevUse_LicenseID");
		ulbPrevUse_LicenseID.setBounds(200, 180, 100, 40);
		ulbPrevUse_LicenseID.setFont(new Font("Verdana", Font.PLAIN, 9));
		jPanel.add(ulbPrevUse_LicenseID);

		utxtPrevUse_LicenseID = new JTextField();
		utxtPrevUse_LicenseID.setBounds(320, 190, 60, 30);
		jPanel.add(utxtPrevUse_LicenseID);

		// PrevUse_CarRegtID
		JLabel ulbPrevUse_CarRegtID = new JLabel("PrevUse_CarRegtID");
		ulbPrevUse_CarRegtID.setBounds(390, 180, 100, 40);
		ulbPrevUse_CarRegtID.setFont(new Font("Verdana", Font.PLAIN, 8));
		jPanel.add(ulbPrevUse_CarRegtID);

		utxtPrevUse_CarRegtID = new JTextField();
		utxtPrevUse_CarRegtID.setBounds(510, 190, 60, 30);
		jPanel.add(utxtPrevUse_CarRegtID);

		// PrevUseDate
		JLabel ulbPrevUseDate = new JLabel("PrevUseDate");
		ulbPrevUseDate.setBounds(580, 180, 100, 40);
		ulbPrevUseDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(ulbPrevUseDate);

		utxtPrevUseDate = new JTextField();
		utxtPrevUseDate.setBounds(700, 190, 60, 30);
		jPanel.add(utxtPrevUseDate);
		// btnUpdate
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(350, 270, 90, 35);
		btnUpdate.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnUpdate.addActionListener(btnL);
		jPanel.add(btnUpdate);

		JLabel updateLine = new JLabel(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		updateLine.setBounds(10, 300, 800, 35);
		jPanel.add(updateLine);

		/******** DELETE ********/
		JLabel lbDelete = new JLabel("DELETE");
		lbDelete.setBounds(10, 320, 90, 40);
		lbDelete.setFont(new Font("Verdana", Font.PLAIN, 17));
		jPanel.add(lbDelete);

		// PrevUseNo
		JLabel dlbPrevUseNo = new JLabel("PrevUseNo");
		dlbPrevUseNo.setBounds(10, 350, 100, 40);
		dlbPrevUseNo.setFont(new Font("Verdana", Font.PLAIN, 13));
		jPanel.add(dlbPrevUseNo);

		dtxtPrevUseNo = new JTextField();
		dtxtPrevUseNo.setBounds(150, 360, 60, 30);
		jPanel.add(dtxtPrevUseNo);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(350, 390, 80, 35);
		btnDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnDelete.addActionListener(btnL);
		jPanel.add(btnDelete);

		return jPanel;
	} // PrevUse

	/************ SHOW ************/
	private JPanel showCampingcarTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Identify frequent maintenance customers");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Understand how many customers are using");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription("campingcar");
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<CampingcarVO> arrCampingcarVO = dbConnect.selectCampingcar(condition);
		for (int i = 0; i < arrCampingcarVO.size(); i++) {
			rowData[0] = arrCampingcarVO.get(i).getCarRegtID();
			rowData[1] = arrCampingcarVO.get(i).getCampingcar_RentCorpID();
			rowData[2] = arrCampingcarVO.get(i).getCarName();
			rowData[3] = arrCampingcarVO.get(i).getCarNum();
			rowData[4] = arrCampingcarVO.get(i).getCarMaxPeopNum();
			rowData[5] = arrCampingcarVO.get(i).getCarImage();
			rowData[6] = arrCampingcarVO.get(i).getCarInfo();
			rowData[7] = arrCampingcarVO.get(i).getCarRentCost();
			rowData[8] = arrCampingcarVO.get(i).getCarRegtDate();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	private JPanel showRentCorpTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Identify frequent maintenance customers");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Understand how many customers are using");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription("RentCorp");
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();

			System.out.println("############" + columnsName[i]);
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<RentCorpVO> arrRentCorpVO = dbConnect.selectRentCorp();
		for (int i = 0; i < arrRentCorpVO.size(); i++) {
			rowData[0] = arrRentCorpVO.get(i).getRentCorpID();
			rowData[1] = arrRentCorpVO.get(i).getCorpName();
			rowData[2] = arrRentCorpVO.get(i).getCity();
			rowData[3] = arrRentCorpVO.get(i).getKu();
			rowData[4] = arrRentCorpVO.get(i).getDong();
			rowData[5] = arrRentCorpVO.get(i).getCorpPhoneNum();
			rowData[6] = arrRentCorpVO.get(i).getCorpManagerName();
			rowData[7] = arrRentCorpVO.get(i).getCorpManagerMail();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	private JPanel showRepairShopTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Identify frequent maintenance customers");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Understand how many customers are using");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription("Repairshop");
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();

		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<RepairShopVO> arrRepairShopVO = dbConnect.selectRepairShop();
		for (int i = 0; i < arrRepairShopVO.size(); i++) {
			rowData[0] = arrRepairShopVO.get(i).getShopID();
			rowData[1] = arrRepairShopVO.get(i).getShopName();
			rowData[2] = arrRepairShopVO.get(i).getCity();
			rowData[3] = arrRepairShopVO.get(i).getKu();
			rowData[4] = arrRepairShopVO.get(i).getDong();
			rowData[5] = arrRepairShopVO.get(i).getShopPhoneNum();
			rowData[6] = arrRepairShopVO.get(i).getShopManagerName();
			rowData[7] = arrRepairShopVO.get(i).getShopManagerMail();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	private JPanel showRentalTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Find a repairshop in the same city");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Find the average of car rent cost by the maximum number of passengers");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JButton btnSelect3 = new JButton("Find a cheap and unused camping car");
		btnSelect3.setBounds(100, 150, 550, 35);
		btnSelect3.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect3.addActionListener(btnL);
		jPanel.add(btnSelect3);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription("Rental");
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<RentalVO> arrRentalVO = dbConnect.selectRental();
		for (int i = 0; i < arrRentalVO.size(); i++) {
			rowData[0] = arrRentalVO.get(i).getRentalID();
			rowData[1] = arrRentalVO.get(i).getRental_CarRegtID();
			rowData[2] = arrRentalVO.get(i).getRental_LicenseID();
			rowData[3] = arrRentalVO.get(i).getRental_RentCompanyID();
			rowData[4] = arrRentalVO.get(i).getRentStartDate();
			rowData[5] = arrRentalVO.get(i).getRentPeriod();
			rowData[6] = arrRentalVO.get(i).getRentPrice();
			rowData[7] = arrRentalVO.get(i).getPaymentDue();
			rowData[8] = arrRentalVO.get(i).getEtcBillDetail();
			rowData[9] = arrRentalVO.get(i).getEtcBillPrice();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	private JPanel showRepairTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Find a repairshop in the same city");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Find the average of car rent cost by the maximum number of passengers");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JButton btnSelect3 = new JButton("Find a cheap and unused camping car");
		btnSelect3.setBounds(100, 150, 550, 35);
		btnSelect3.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect3.addActionListener(btnL);
		jPanel.add(btnSelect3);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription("Repair");
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<RepairVO> arrRepairVO = dbConnect.selectRepair();
		for (int i = 0; i < arrRepairVO.size(); i++) {
			rowData[0] = arrRepairVO.get(i).getRepairID();
			rowData[1] = arrRepairVO.get(i).getRepair_CarRegtID();
			rowData[2] = arrRepairVO.get(i).getRepair_ShopID();
			rowData[3] = arrRepairVO.get(i).getRepair_RentCompanyID();
			rowData[4] = arrRepairVO.get(i).getRepair_LicenseID();
			rowData[5] = arrRepairVO.get(i).getRepairHistory();
			rowData[6] = arrRepairVO.get(i).getRepairDate();
			rowData[7] = arrRepairVO.get(i).getRepairPrice();
			rowData[8] = arrRepairVO.get(i).getPaymentDue();
			rowData[9] = arrRepairVO.get(i).getEtcRepairInfo();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	private JPanel showCustomerTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Find a repairshop in the same city");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Find the average of car rent cost by the maximum number of passengers");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JButton btnSelect3 = new JButton("Find a cheap and unused camping car");
		btnSelect3.setBounds(100, 150, 550, 35);
		btnSelect3.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect3.addActionListener(btnL);
		jPanel.add(btnSelect3);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription("Customer");
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<CustomerVO> arrCustomerVO = dbConnect.selectCustomer();
		for (int i = 0; i < arrCustomerVO.size(); i++) {
			rowData[0] = arrCustomerVO.get(i).getLicenseID();
			rowData[1] = arrCustomerVO.get(i).getCusName();
			rowData[2] = arrCustomerVO.get(i).getCity();
			rowData[3] = arrCustomerVO.get(i).getKu();
			rowData[4] = arrCustomerVO.get(i).getDong();
			rowData[5] = arrCustomerVO.get(i).getCusPhoneNum();
			rowData[6] = arrCustomerVO.get(i).getCusMail();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	private JPanel showPrevUseTable(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		// btnSelect
		JButton btnSelect1 = new JButton("Find a repairshop in the same city");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Find the average of car rent cost by the maximum number of passengers");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JButton btnSelect3 = new JButton("Find a cheap and unused camping car");
		btnSelect3.setBounds(100, 150, 550, 35);
		btnSelect3.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect3.addActionListener(btnL);
		jPanel.add(btnSelect3);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription("PrevUse");
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<PrevUseVO> arrPrevUseVO = dbConnect.selectPrevUse();
		for (int i = 0; i < arrPrevUseVO.size(); i++) {
			rowData[0] = arrPrevUseVO.get(i).getPrevUseNo();
			rowData[1] = arrPrevUseVO.get(i).getPrevUse_LicenseID();
			rowData[2] = arrPrevUseVO.get(i).getPrevUse_CarRegtID();
			rowData[3] = arrPrevUseVO.get(i).getPrevUseDate();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	// 여기야
	// @@@
	private JPanel getFreqRepairCustomer(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Identify frequent maintenance customers");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Understand how many customers are using");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[2];

		columnsName[0] = "licenseID";
		columnsName[1] = "cusName";

		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[2];
		ArrayList<FreqRepairCustomerVO> arrFreqRepairCustomerVO = dbConnect.selectFreqRepairCustomer();
		for (int i = 0; i < arrFreqRepairCustomerVO.size(); i++) {
			rowData[0] = arrFreqRepairCustomerVO.get(i).getLicenseID();
			rowData[1] = arrFreqRepairCustomerVO.get(i).getCusName();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	// @@@
	private JPanel getCountRental(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Identify frequent maintenance customers");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Understand how many customers are using");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[2];

		columnsName[0] = "prevUse_LicenseID";
		columnsName[1] = "Count";

		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[2];
		ArrayList<CountRentalVO> arrCountRentalVO = dbConnect.selectCountRental();
		for (int i = 0; i < arrCountRentalVO.size(); i++) {
			rowData[0] = arrCountRentalVO.get(i).getPrevUse_licenseID();
			rowData[1] = arrCountRentalVO.get(i).getCount();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	// @@@
	private JPanel getRepairShopLoc(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Find a repairshop in the same city");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Find the average of car rent cost by the maximum number of passengers");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JButton btnSelect3 = new JButton("Find a cheap and unused camping car");
		btnSelect3.setBounds(100, 150, 550, 35);
		btnSelect3.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect3.addActionListener(btnL);
		jPanel.add(btnSelect3);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[2];

		columnsName[0] = "city";
		columnsName[1] = "Count";

		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[2];
		ArrayList<RepairShopLocVO> arrRepairShopLocVO = dbConnect.selectRepairShopLoc();
		for (int i = 0; i < arrRepairShopLocVO.size(); i++) {
			rowData[0] = arrRepairShopLocVO.get(i).getCity();
			rowData[1] = arrRepairShopLocVO.get(i).getCount();
			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	// @@@
	private JPanel getAvgCarRentCost(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Find a repairshop in the same city");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Find the average of car rent cost by the maximum number of passengers");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JButton btnSelect3 = new JButton("Find a cheap and unused camping car");
		btnSelect3.setBounds(100, 150, 550, 35);
		btnSelect3.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect3.addActionListener(btnL);
		jPanel.add(btnSelect3);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[2];

		columnsName[0] = "carMaxPeopNum";
		columnsName[1] = "averageCost";

		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[2];
		ArrayList<AvgCarRentCostVO> arrAvgCarRentCostVO = dbConnect.selectAvgCarRentCost();
		for (int i = 0; i < arrAvgCarRentCostVO.size(); i++) {
			rowData[0] = arrAvgCarRentCostVO.get(i).getCarMaxPeopnum();
			rowData[1] = arrAvgCarRentCostVO.get(i).getAvg_carrentCost();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	// @@@
	private JPanel getCheapNewCampingcar(String condition) {
		JPanel jPanel = new JPanel();
		jPanel.setBounds(0, 0, 800, 450);
		jPanel.setBackground(new Color(245, 245, 245));
		jPanel.setLayout(null);

		// btnSelect
		JButton btnSelect1 = new JButton("Find a repairshop in the same city");
		btnSelect1.setBounds(100, 50, 550, 35);
		btnSelect1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect1.addActionListener(btnL);
		jPanel.add(btnSelect1);

		JButton btnSelect2 = new JButton("Find the average of car rent cost by the maximum number of passengers");
		btnSelect2.setBounds(100, 100, 550, 35);
		btnSelect2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect2.addActionListener(btnL);
		jPanel.add(btnSelect2);

		JButton btnSelect3 = new JButton("Find a cheap and unused camping car");
		btnSelect3.setBounds(100, 150, 550, 35);
		btnSelect3.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnSelect3.addActionListener(btnL);
		jPanel.add(btnSelect3);

		JTable jTable = new JTable();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription("Campingcar");
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<CampingcarVO> arrCampingcarVO = dbConnect.selectCheapNewCampingcar();
		for (int i = 0; i < arrCampingcarVO.size(); i++) {
			rowData[0] = arrCampingcarVO.get(i).getCarRegtID();
			rowData[1] = arrCampingcarVO.get(i).getCampingcar_RentCorpID();
			rowData[2] = arrCampingcarVO.get(i).getCarName();
			rowData[3] = arrCampingcarVO.get(i).getCarNum();
			rowData[4] = arrCampingcarVO.get(i).getCarMaxPeopNum();
			rowData[5] = arrCampingcarVO.get(i).getCarImage();
			rowData[6] = arrCampingcarVO.get(i).getCarInfo();
			rowData[7] = arrCampingcarVO.get(i).getCarRentCost();
			rowData[8] = arrCampingcarVO.get(i).getCarRegtDate();

			model.addRow(rowData);
		}

		jTable.setModel(model);
		jTable.setPreferredScrollableViewportSize(jTable.getPreferredSize());
		jTable.setFillsViewportHeight(true);
		jTable.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 11));
		jTable.setFont(new Font("Verdana", Font.PLAIN, 11));
		jTable.setRowHeight(20);

		jScollPane = new JScrollPane(jTable);
		jScollPane.setPreferredSize(new Dimension(750, 150));
		jScollPane.setBounds(30, 220, 750, 150);
		jScollPane.getVerticalScrollBar().setValue(jScollPane.getVerticalScrollBar().getMaximum());

		jPanel.add(jScollPane);

		return jPanel;
	}

	private class BtnListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			JButton b = (JButton) event.getSource();
			String tableName;
			String condition = "";

			String btnName = null;
			btnName = b.getText();

			switch (btnName) {

			case "Search":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				tableName = strMenu[cmbMenu.getSelectedIndex()];
				condition = "";
				jTable = null;
				tempPanel = null;

				switch (tableName) {
				case "Admin":
					tempPanel = getAdminTable(condition);
					break;
				case "User":
					tempPanel = getUserTable(condition);
					break;
				}

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;

			case "Show":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				tableName = strMenu[cmbMenu.getSelectedIndex()];
				condition = "";
				jTable = null;
				tempPanel = null;
				if (tableName == "Admin") {
					tableName = showAdminMenu[adminCbMenu.getSelectedIndex()];
					switch (tableName) {
					case "campingcar":
						tempPanel = showCampingcarTable(condition);
						break;
					case "rentCorp":
						tempPanel = showRentCorpTable(condition);
						break;
					case "repairShop":
						tempPanel = showRepairShopTable(condition);
						break;

					}
				}

				if (tableName == "User") {
					tableName = showUserMenu[userCbMenu.getSelectedIndex()];
					switch (tableName) {
					case "rental":
						tempPanel = showRentalTable(condition);
						break;
					case "repair":
						tempPanel = showRepairTable(condition);
						break;
					case "customer":
						tempPanel = showCustomerTable(condition);
						break;
					case "prevUse":
						tempPanel = showPrevUseTable(condition);
						break;
					}
				}

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;
			/*
			 * case "": //select 그 버튼에 있는 내용 여기다가 적고 이때 실행할 수 있는 함수 다시 만들어서
			 * 해야될거야 그 showRentCorpTable 이거 참고해서 밑에랑 같은 형식으로 넣으면 돼 이거 select
			 * 이름으로 5개 만들고 show table 함수는 내가 만들기는 했는데 거기에 있는 Array 그부분하고 VO
			 * 넣은다음에 연결시켜야돼
			 * 
			 */
			// @@@
			case "Identify frequent maintenance customers":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				condition = "";
				jTable = null;
				tempPanel = getFreqRepairCustomer(condition);

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;

			// @@@
			case "Understand how many customers are using":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				condition = "";
				jTable = null;
				tempPanel = getCountRental(condition);

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;

			// @@@
			case "Find a repairshop in the same city":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				condition = "";
				jTable = null;
				tempPanel = getRepairShopLoc(condition);

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;

			// @@@
			case "Find the average of car rent cost by the maximum number of passengers":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				condition = "";
				jTable = null;
				tempPanel = getAvgCarRentCost(condition);

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;

			// @@@
			case "Find a cheap and unused camping car":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				condition = "";
				jTable = null;
				tempPanel = getCheapNewCampingcar(condition);

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;

			case "Pick":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				tableName = strMenu[cmbMenu.getSelectedIndex()];
				condition = "";
				jTable = null;
				tempPanel = null;

				switch (tableName) {
				case "Admin":
					tableName = showAdminMenu[adminCbMenu.getSelectedIndex()];
					switch (tableName) {
					case "campingcar":
						tempPanel = getCampingcarTable(condition);
						break;
					case "rentCorp":
						tempPanel = getRentCorpTable(condition);
						break;
					case "repairShop":
						tempPanel = getRepairShopTable(condition);
						break;
					}
					break;
				case "User":
					tableName = showUserMenu[userCbMenu.getSelectedIndex()];
					switch (tableName) {
					case "rental":
						tempPanel = getRentalTable(condition);
						break;
					case "repair":
						tempPanel = getRepairTable(condition);
						break;
					case "customer":
						tempPanel = getCustomerTable(condition);
						break;
					case "prevUse":

						tempPanel = getPrevUseTable(condition);
						break;

					}
					break;

				}

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;

			case "1":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				pickButton.setVisible(false);

				tableName = strMenu[cmbMenu.getSelectedIndex()];
				condition = "";
				jTable = null;
				tempPanel = null;

				switch (tableName) {
				case "Admin":
					tempPanel = getAdminTable(condition);

					break;
				case "User":
					tempPanel = getUserTable(condition);
					break;
				}

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;
			case "2":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				showButton.setVisible(false);
				pickButton.setVisible(true);

				tableName = strMenu[cmbMenu.getSelectedIndex()];
				condition = "";
				jTable = null;
				tempPanel = null;
				if (tableName == "Admin")
					tempPanel = getCampingcarTable(condition);
				else if (tableName == "User")
					tempPanel = getRentalTable(condition);

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;
			case "3":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				showButton.setVisible(false);
				pickButton.setVisible(false);

				tableName = strMenu[cmbMenu.getSelectedIndex()];
				condition = "";
				jTable = null;
				tempPanel = null;

				dbConnect.initAll();

				dbConnect.initCustomer();
				dbConnect.initRentcorp();
				dbConnect.initCampingcar();
				dbConnect.initRepairshop();
				dbConnect.initRental();
				dbConnect.initRepair();
				dbConnect.initPrevuse();

				JOptionPane.showMessageDialog(null,"Init Complete!!");
				
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;
			case "4":
				System.exit(0);

			case "Insert":

				tableName = strMenu[cmbMenu.getSelectedIndex()];
				jTable = null;
				// tempPanel = null;

				switch (tableName) {
				case "Admin":
					tableName = showAdminMenu[adminCbMenu.getSelectedIndex()];

					System.out.println("insert button click###");
					switch (tableName) {
					case "campingcar":

						System.out.println("###@#@#@#@#booboo");
						dbConnect.insertCampingcar(txtCarRegtID.getText(), txtCampingcar_RentCorpID.getText(),
								txtCarName.getText(), txtCarNum.getText(),Integer.parseInt(txtCarMaxPeopNum.getText()),
								txtCarImage.getText(), txtCarInfo.getText(), Integer.parseInt(txtcarRentCost.getText()),
								txtCarRegtDate.getText());
						break;
					case "rentCorp":
						dbConnect.insertRentCorp(txtRentCorpID.getText(), txtCorpName.getText(), txtCity.getText(),
								txtKu.getText(), txtDong.getText(), txtCorpPhoneNum.getText(),
								txtCorpManagerName.getText(), txtCorpManagerMail.getText());
						break;
					case "repairShop":
						dbConnect.insertRepairShop(txtShopID.getText(), txtShopName.getText(), txtCity.getText(),
								txtKu.getText(), txtDong.getText(), txtShopPhoneNum.getText(),
								txtShopManagerName.getText(), txtShopManagerMail.getText());
						break;
					}
					break;
				case "User":
					tableName = showUserMenu[userCbMenu.getSelectedIndex()];

					System.out.println("insert button click");
					switch (tableName) {
					case "rental":
						dbConnect.insertRental(txtRentalID.getText(), txtRental_CarRegtID.getText(),
								txtRental_LicenseID.getText(), txtRental_RentCompanyID.getText(),
								txtRentStartDate.getText(), Integer.parseInt(txtRentPeriod.getText()),
								Integer.parseInt(txtRentPrice.getText()), txtPaymentDue.getText(),
								txtEtcBillDetail.getText(), Integer.parseInt(txtEtcBillPrice.getText()));
						break;
					case "repair":
						dbConnect.insertRepair(Integer.parseInt(txtRepairID.getText()), txtRepair_CarRegtID.getText(),
								txtRepair_ShopID.getText(), txtRepair_RentCompanyID.getText(),
								txtRepair_LicenseID.getText(), txtRepairHistory.getText(), txtRepairDate.getText(),
								Integer.parseInt(txtRepairPrice.getText()), txtPaymentDue.getText(),
								txtEtcRepairInfo.getText());

						break;
					case "customer":
						dbConnect.insertCustomer(txtLicenseID.getText(), txtCusName.getText(), txtCity.getText(),
								txtKu.getText(), txtDong.getText(), txtCusPhoneNum.getText(), txtCusMail.getText());

						break;
					case "prevUse":
						System.out.println("##prevuse##");
						dbConnect.insertPrevUse(Integer.parseInt(txtPrevUseNo.getText()),
								txtPrevUse_LicenseID.getText(), txtPrevUse_CarRegtID.getText(),
								txtPrevUseDate.getText());

						break;
					}
					break;
				}

				setVisible(true);
				validate();
				repaint();
				break;

			case "Update":
				tableName = strMenu[cmbMenu.getSelectedIndex()];
				jTable = null;
				tempPanel = null;

				switch (tableName) {
				case "Admin":
					tableName = showAdminMenu[adminCbMenu.getSelectedIndex()];
					switch (tableName) {
					case "campingcar":
						dbConnect.updateCampingcar(utxtCarRegtID.getText(), utxtCampingcar_RentCorpID.getText(),
								utxtCarName.getText(), utxtCarNum.getText(),
								Integer.parseInt(utxtCarMaxPeopNum.getText()), utxtCarImage.getText(),
								utxtCarInfo.getText(), Integer.parseInt(utxtcarRentCost.getText()),
								utxtCarRegtDate.getText());
						break;
					case "rentCorp":
						dbConnect.updateRentCorp(utxtRentCorpID.getText(), utxtCorpName.getText(), utxtCity.getText(),
								utxtKu.getText(), utxtDong.getText(), utxtCorpPhoneNum.getText(),
								utxtCorpManagerName.getText(), utxtCorpManagerMail.getText());
						break;
					case "repairShop":
						dbConnect.updateRepairShop(utxtShopID.getText(), utxtShopName.getText(), utxtCity.getText(),
								utxtKu.getText(), utxtDong.getText(), utxtShopPhoneNum.getText(),
								utxtShopManagerName.getText(), utxtShopManagerMail.getText());

						break;
					}
					break;
					case "User":
						tableName = showUserMenu[userCbMenu.getSelectedIndex()];
						switch (tableName) {
						case "rental":
							dbConnect.updateRental(utxtRentalID.getText(), utxtRental_CarRegtID.getText(),
									utxtRental_LicenseID.getText(), utxtRental_RentCompanyID.getText(),
									utxtRentStartDate.getText(), Integer.parseInt(utxtRentPeriod.getText()),
									Integer.parseInt(utxtRentPrice.getText()), utxtPaymentDue.getText(),
									utxtEtcBillDetail.getText(), Integer.parseInt(utxtEtcBillPrice.getText()));

							break;
						case "repair":
							dbConnect.updateRepair(Integer.parseInt(utxtRepairID.getText()),
									utxtRepair_CarRegtID.getText(), utxtRepair_ShopID.getText(),
									utxtRepair_RentCompanyID.getText(), utxtRepair_LicenseID.getText(),
									utxtRepairHistory.getText(), utxtRepairDate.getText(),
									Integer.parseInt(utxtRepairPrice.getText()), utxtPaymentDue.getText(),
									utxtEtcRepairInfo.getText());

							break;
						case "customer":
							dbConnect.updateCustomer(utxtLicenseID.getText(), utxtCusName.getText(), utxtCity.getText(),
									utxtKu.getText(), utxtDong.getText(), utxtCusPhoneNum.getText(),
									utxtCusMail.getText());
							break;
						case "prevUse":
							dbConnect.updatePrevUse(Integer.parseInt(utxtPrevUseNo.getText()),
									utxtPrevUse_LicenseID.getText(), utxtPrevUse_CarRegtID.getText(),
									utxtPrevUseDate.getText());

							break;
						}
						break;
					
				}

				setVisible(true);
				validate();
				repaint();
				break;

			case "Delete":
				tableName = strMenu[cmbMenu.getSelectedIndex()];
				jTable = null;
				tempPanel = null;

				switch (tableName) {

				case "Admin":
					tableName = showAdminMenu[adminCbMenu.getSelectedIndex()];
					switch (tableName) {
					case "campingcar":
						dbConnect.deleteCampingcar(dtxtCarRegtID.getText());
						break;
					case "rentCorp":
						System.out.println("deleterentcorp#####");
						dbConnect.deleteRentCorp(dtxtRentCorpID.getText());
						break;
					case "repairShop":
						dbConnect.deleteRepairShop(dtxtShopID.getText());
						break;
					}
					break;
				case "User":
					tableName = showUserMenu[userCbMenu.getSelectedIndex()];
					switch (tableName) {
					case "rental":
						dbConnect.deleteRental(dtxtRentalID.getText());
						break;
					case "repair":
						dbConnect.deleteRepair(dtxtRepairID.getText());
						break;
					case "customer":
						dbConnect.deleteCustomer(dtxtLicenseID.getText());
						break;
					case "prevUse":
						dbConnect.deletePrevUse(dtxtPrevUseNo.getText());
						break;
					}
					break;
				}

				setVisible(true);
				validate();
				repaint();
				break;

			case "Select":
				mainPanel.removeAll();
				mainPanel.setLayout(null);

				tableName = strMenu[cmbMenu.getSelectedIndex()];
				jTable = null;
				tempPanel = null;

				switch (tableName) {
				/*
				 * case "CUSTOMER": condition = "where "; condition +=
				 * txtCusWhere.getText(); tempPanel =
				 * getCustomerTable(condition); break;
				 */

				}

				mainPanel.add(tempPanel);
				add(mainPanel);

				setVisible(true);
				validate();
				repaint();
				break;

			}
		}
	} // BtnListener class
} // PrimaryPanel class

// DB
////////////
class DatabaseConnect {
	private Connection conn = null;
	private Statement stmt = null;

	private static final String USERNAME = "s16010946";
	private static final String PASSWORD = "zg580200";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";

	public DatabaseConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("DB Connection OK!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB Driver Error!");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB Connection Error!");

		}
	}

	public ArrayList<DescribeTableVO> getTableDescription(String tableName) {
		String sql = "select COLUMN_NAME from COLS where table_Name=?";
		PreparedStatement pstmt = null;
		ArrayList<DescribeTableVO> arrDescribeTableVO = new ArrayList<DescribeTableVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tableName.toUpperCase());
			ResultSet rs = pstmt.executeQuery();

			System.out.println(tableName);

			while (rs.next()) {
				System.out.println("getTableDescription");
				System.out.println(rs.getString("COLUMN_NAME"));
				DescribeTableVO tempDescribeTableVO = new DescribeTableVO(rs.getString("COLUMN_NAME"));
				arrDescribeTableVO.add(tempDescribeTableVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrDescribeTableVO;
	}

	public ArrayList<CampingcarVO> selectCampingcar(String condition) {
		String sql = "select * from campingcar order by carRegtID";
		sql += condition;
		PreparedStatement pstmt = null;
		ArrayList<CampingcarVO> arrCampingcarVO = new ArrayList<CampingcarVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CampingcarVO tempCampingcarVO = new CampingcarVO(rs.getString("carRegtID"),
						rs.getString("campingcar_RentCorpID"), rs.getString("carName"), rs.getString("carNum"),
						rs.getInt("carMaxPeopNum"), rs.getString("carImage"), rs.getString("carInfo"),
						rs.getInt("carRentCost"), rs.getString("carRegtDate"));
				arrCampingcarVO.add(tempCampingcarVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrCampingcarVO;
	}

	// ------------------------------SELECT------------------------------------//

	// selectCampingcar()

	// selectCustomer()
	public ArrayList<CustomerVO> selectCustomer() {
		String sql = "select * from customer order by licenseID";
		PreparedStatement pstmt = null;
		ArrayList<CustomerVO> arrCustomerVO = new ArrayList<CustomerVO>();

		try {

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CustomerVO tempCustomerVO = new CustomerVO(rs.getString("licenseID"), rs.getString("cusName"),
						rs.getString("city"), rs.getString("ku"), rs.getString("dong"), rs.getString("cusPhoneNum"),
						rs.getString("cusMail"));
				arrCustomerVO.add(tempCustomerVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrCustomerVO;
	} // selectCustomer()

	// selectPrevUse()
	public ArrayList<PrevUseVO> selectPrevUse() {
		String sql = "select * from prevuse order by prevUseNo";

		PreparedStatement pstmt = null;
		ArrayList<PrevUseVO> arrPrevUseVO = new ArrayList<PrevUseVO>();

		try {

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				PrevUseVO tempPrevUseVO = new PrevUseVO(rs.getInt("prevUseNo"), rs.getString("prevUse_LicenseID"),
						rs.getString("prevUse_CarRegtID"), rs.getString("prevUseDate"));
				arrPrevUseVO.add(tempPrevUseVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrPrevUseVO;
	} // selectPrevUse()

	// selectRental()
	public ArrayList<RentalVO> selectRental() {
		String sql = "select * from rental order by rentalID";

		PreparedStatement pstmt = null;
		ArrayList<RentalVO> arrRentalVO = new ArrayList<RentalVO>();

		try {

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RentalVO tempRentalVO = new RentalVO(rs.getString("rentalID"), rs.getString("rental_CarRegtID"),
						rs.getString("rental_LicenseID"), rs.getString("rental_RentCompanyID"),
						rs.getString("rentStartDate"), rs.getInt("rentPeriod"), rs.getInt("rentPrice"),
						rs.getString("paymentDue"), rs.getString("etcBillDetail"), rs.getInt("etcBillPrice"));
				arrRentalVO.add(tempRentalVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrRentalVO;
	} // selectRental()

	// selectRentCorp()
	public ArrayList<RentCorpVO> selectRentCorp() {
		String sql = "select * from rentcorp order by rentCorpID ASC ";

		PreparedStatement pstmt = null;
		ArrayList<RentCorpVO> arrRentCorpVO = new ArrayList<RentCorpVO>();

		try {

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RentCorpVO tempRentCorpVO = new RentCorpVO(rs.getString("rentCorpID"), rs.getString("corpName"),
						rs.getString("city"), rs.getString("ku"), rs.getString("dong"), rs.getString("corpPhoneNum"),
						rs.getString("corpManagerName"), rs.getString("corpManagerMail"));
				arrRentCorpVO.add(tempRentCorpVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrRentCorpVO;
	} // selectRentCorp()

	// selectRepairShop()
	public ArrayList<RepairShopVO> selectRepairShop() {
		String sql = "select * from repairshop order by shopID";

		PreparedStatement pstmt = null;
		ArrayList<RepairShopVO> arrRepairShopVO = new ArrayList<RepairShopVO>();

		try {

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RepairShopVO tempRepairShopVO = new RepairShopVO(rs.getString("shopID"), rs.getString("shopName"),
						rs.getString("city"), rs.getString("ku"), rs.getString("dong"), rs.getString("shopPhoneNum"),
						rs.getString("shopManagerName"), rs.getString("shopManagerMail"));
				arrRepairShopVO.add(tempRepairShopVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrRepairShopVO;
	} // selectRepairShop()

	// selectRepair()
	public ArrayList<RepairVO> selectRepair() {
		String sql = "select * from repair order by repairID";

		PreparedStatement pstmt = null;
		ArrayList<RepairVO> arrRepairVO = new ArrayList<RepairVO>();

		try {

			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RepairVO tempRepairVO = new RepairVO(rs.getInt("repairID"), rs.getString("repair_CarRegtID"),
						rs.getString("repair_ShopID"), rs.getString("repair_RentCompanyID"),
						rs.getString("repair_LicenseID"), rs.getString("repairHistory"), rs.getString("repairDate"),
						rs.getInt("repairPrice"), rs.getString("paymentDue"), rs.getString("etcRepairInfo"));
				arrRepairVO.add(tempRepairVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrRepairVO;
	} // SelectRepair()

	// @@@
	// selectFreqRepairCustomer()
	public ArrayList<FreqRepairCustomerVO> selectFreqRepairCustomer() {

		String sql = "select licenseID, cusName from customer where licenseID in (select repair_licenseID from repair group by repair_licenseID having count(*)>=2)";
		// repair count 횟수 많은 순서대로 보여주고 싶은데 order by가 어디에 들어가야 하는거지?

		PreparedStatement pstmt = null;
		ArrayList<FreqRepairCustomerVO> arrFreqRepairCustomer = new ArrayList<FreqRepairCustomerVO>();

		try {

			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				FreqRepairCustomerVO tempFreqRepairCustomer = new FreqRepairCustomerVO(rs.getString("licenseID"),
						rs.getString("cusName"));
				arrFreqRepairCustomer.add(tempFreqRepairCustomer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrFreqRepairCustomer;
	} // selectFreqRepairCustomer()

	// @@@
	// selectCountRental()
	public ArrayList<CountRentalVO> selectCountRental() {

		String sql = "select prevUse_licenseID,count(*) from prevuse group by prevUse_licenseID having count(*)>=2";

		PreparedStatement pstmt = null;
		ArrayList<CountRentalVO> arrCountRental = new ArrayList<CountRentalVO>();

		try {

			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CountRentalVO tempCountRental = new CountRentalVO(rs.getString("prevUse_licenseID"),
						rs.getInt("count(*)"));
				System.out.println(tempCountRental);
				arrCountRental.add(tempCountRental);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrCountRental;
	} // selectCountRental()

	// @@
	// selectRepairShopLoc()
	public ArrayList<RepairShopLocVO> selectRepairShopLoc() {

		String sql = "select city,count(*) from repairshop group by city having count(*)>=2";

		PreparedStatement pstmt = null;
		ArrayList<RepairShopLocVO> arrRepairshopLoc = new ArrayList<RepairShopLocVO>();

		try {

			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RepairShopLocVO tempRepairshopLoc = new RepairShopLocVO(rs.getString("city"), rs.getInt("count(*)"));
				arrRepairshopLoc.add(tempRepairshopLoc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrRepairshopLoc;
	} // selectRepairShopLoc()

	// @@@
	// selectAvgCarRentCost()
	public ArrayList<AvgCarRentCostVO> selectAvgCarRentCost() {

		String sql = "select carMaxPeopNum,avg(carrentCost) from campingcar group by carMaxPeopNum having count(*)>=2";
		// 같은 최대인원수를 가진 차가 2대이상경우 최대인원수별 차대여가격의 평균

		PreparedStatement pstmt = null;
		ArrayList<AvgCarRentCostVO> arrAvgCarRentCost = new ArrayList<AvgCarRentCostVO>();

		try {

			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				AvgCarRentCostVO tempAvgCarRentCost = new AvgCarRentCostVO(rs.getInt("carMaxPeopNum"),
						rs.getInt("avg(carrentCost)"));
				arrAvgCarRentCost.add(tempAvgCarRentCost);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrAvgCarRentCost;
	}

	// @@@
	// selectCheapNewCampingcar()
	public ArrayList<CampingcarVO> selectCheapNewCampingcar() {

		String sql = "select * from Campingcar where carRegtID not in (select prevUse_carRegtID from prevuse) order by carrentCost ASC";

		PreparedStatement pstmt = null;
		ArrayList<CampingcarVO> arrCheapNewCampingcar = new ArrayList<CampingcarVO>();

		try {

			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CampingcarVO tempCheapNewCampingcar = new CampingcarVO(rs.getString("carRegtID"),
						rs.getString("campingcar_rentCorpID"), rs.getString("carName"), rs.getString("carNum"),
						rs.getInt("carMaxPeopNum"), rs.getString("carImage"), rs.getString("carInfo"),
						rs.getInt("carrentCost"), rs.getString("carRegtDate"));
				arrCheapNewCampingcar.add(tempCheapNewCampingcar);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrCheapNewCampingcar;
	} // selectCheapNewCampingcar()

	// ------------------------------INSERT------------------------------------//

	// InsertCustomer()
	public void insertCustomer(String LicenseID, String CusName, String City, String Ku, String Dong,
			String CusPhoneNum, String CusMail) {
		String sql = "insert into customer values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LicenseID);
			pstmt.setString(2, CusName);
			pstmt.setString(3, City);
			pstmt.setString(4, Ku);
			pstmt.setString(5, Dong);
			pstmt.setString(6, CusPhoneNum);
			pstmt.setString(7, CusMail);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // InsertCustomer()

	// InsertCampingcar()
	public void insertCampingcar(String CarRegtID, String campingcar_RentCorpID, String CarName, String CarNum,
			int CarMaxPeopNum, String CarImage, String CarInfo, int carRentCost, String CarRegtDate) {
		String sql = "insert into campingcar values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		System.out.println("###@#@#@#@#ohoh");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CarRegtID);
			pstmt.setString(2, campingcar_RentCorpID);
			pstmt.setString(3, CarName);
			pstmt.setString(4, CarNum);
			pstmt.setInt(5, CarMaxPeopNum);
			pstmt.setString(6, CarImage);
			pstmt.setString(7, CarInfo);
			pstmt.setInt(8, carRentCost);
			pstmt.setString(9, CarRegtDate);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // InsertCampingcar()

	// InsertPrevuse()
	public void insertPrevUse(int PrevUseNo, String PrevUse_LicenseID, String PrevUse_CarRegtID, String PrevUseDate) {
		String sql = "insert into prevuse values (?,?,?,?)";
		PreparedStatement pstmt = null;
		System.out.println("##prevuse insert start##");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, PrevUseNo);
			pstmt.setString(2, PrevUse_LicenseID);
			pstmt.setString(3, PrevUse_CarRegtID);
			pstmt.setString(4, PrevUseDate);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // InsertPrevuse()

	// InsertRental()
	public void insertRental(String RentalID, String Rental_CarRegtID, String Rental_LicenseID,
			String Rental_RentCompanyID, String RentStartDate, int RentPeriod, int RentPrice, String PaymentDue,
			String EtcBillDetail, int EtcBillPrice) {
		String sql = "insert into rental values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, RentalID);
			pstmt.setString(2, Rental_CarRegtID);
			pstmt.setString(3, Rental_LicenseID);
			pstmt.setString(4, Rental_RentCompanyID);
			pstmt.setString(5, RentStartDate);
			pstmt.setInt(6, RentPeriod);
			pstmt.setInt(7, RentPrice);
			pstmt.setString(8, PaymentDue);
			pstmt.setString(9, EtcBillDetail);
			pstmt.setInt(10, EtcBillPrice);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // InsertRental()

	// InsertRentCorp()
	public void insertRentCorp(String RentCorpID, String CorpName, String City, String Ku, String Dong,
			String CorpPhoneNum, String CorpManagerName, String CorpManagerMail) {
		String sql = "insert into rentcorp values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, RentCorpID);
			pstmt.setString(2, CorpName);
			pstmt.setString(3, City);
			pstmt.setString(4, Ku);
			pstmt.setString(5, Dong);
			pstmt.setString(6, CorpPhoneNum);
			pstmt.setString(7, CorpManagerName);
			pstmt.setString(8, CorpManagerMail);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // InsertRentCorp()

	// InsertRepair()
	public void insertRepair(int RepairID, String Repair_CarRegtID, String Repair_ShopID, String Repair_RentCompanyID,
			String Repair_LicenseID, String RepairHistory, String RepairDate, int RepairPrice, String PaymentDue,
			String EtcRepairInfo) {
		String sql = "insert into repair values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, RepairID);
			pstmt.setString(2, Repair_CarRegtID);
			pstmt.setString(3, Repair_ShopID);
			pstmt.setString(4, Repair_RentCompanyID);
			pstmt.setString(5, Repair_LicenseID);
			pstmt.setString(6, RepairHistory);
			pstmt.setString(7, RepairDate);
			pstmt.setInt(8, RepairPrice);
			pstmt.setString(9, PaymentDue);
			pstmt.setString(10, EtcRepairInfo);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // InsertRepair()

	// InsertRepairShop()
	public void insertRepairShop(String ShopID, String ShopName, String City, String Ku, String Dong,
			String ShopPhoneNum, String ShopManagerName, String ShopManagerMail) {
		String sql = "insert into repairshop values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ShopID);
			pstmt.setString(2, ShopName);
			pstmt.setString(3, City);
			pstmt.setString(4, Ku);
			pstmt.setString(5, Dong);
			pstmt.setString(6, ShopPhoneNum);
			pstmt.setString(7, ShopManagerName);
			pstmt.setString(8, ShopManagerMail);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // InsertRepairShop()

	// ------------------------------DELETE------------------------------------//

	// deleteCustomer()
	public void deleteCustomer(String LicenseID) {

		String sql = "delete from customer where licenseID =?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LicenseID);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // deleteCustomer()

	// deleteCampingcar()
	public void deleteCampingcar(String CarRegtID) {

		String sql = "delete from campingcar where carRegtID =?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CarRegtID);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // deleteCampingcar()

	// deletePrevUse()
	public void deletePrevUse(String PrevUseNo) {

		String sql = "delete from prevuse where prevUseNo =?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PrevUseNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // deletePrevUse()

	// deleteRental()
	public void deleteRental(String RentalID) {

		String sql = "delete from rental where rentalID =?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, RentalID);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // deleteRental()

	// deleteRentCorp()
	public void deleteRentCorp(String RentCorpID) {

		String sql = "delete from rentcorp where rentCorpID =?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, RentCorpID);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // deleteRentCorp()

	// deleteRepair()
	public void deleteRepair(String RepairID) {

		String sql = "delete from repair where repairID =?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, RepairID);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // deleteRepair()

	// deleteRepairShop()
	public void deleteRepairShop(String ShopID) {

		String sql = "delete from repairshop where shopID =?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ShopID);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // deleteRepairShop()

	// ------------------------------UPDATE------------------------------------//

	// updateCustomer()
	public void updateCustomer(String LicenseID, String CusName, String City, String Ku, String Dong,
			String CusPhoneNum, String CusMail) {

		String sql = "update customer set cusName=?, city=?, ku=?, dong=?, cusPhoneNum=?, cusMail=? where licenseID=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, CusName);
			pstmt.setString(2, City);
			pstmt.setString(3, Ku);
			pstmt.setString(4, Dong);
			pstmt.setString(5, CusPhoneNum);
			pstmt.setString(6, CusMail);
			pstmt.setString(7, LicenseID);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // updateCustomer()

	// updateCampingcar()
	public void updateCampingcar(String CarRegtID, String campingcar_RentCorpID, String CarName, String CarNum,
			int CarMaxPeopNum, String CarImage, String CarInfo, int carRentCost, String CarRegtDate) {
		String sql = "update campingcar set campingcar_RentCorpID=?, carName=?, carNum=?, carMaxPeopNum=?, carImage=?, carInfo=?, carRentCost=?, carRegtDate=? where carRegtID=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);


			pstmt.setString(1, campingcar_RentCorpID);
			pstmt.setString(2, CarName);
			pstmt.setString(3, CarNum);
			pstmt.setInt(4, CarMaxPeopNum);
			pstmt.setString(5, CarImage);
			pstmt.setString(6, CarInfo);
			pstmt.setInt(7, carRentCost);
			pstmt.setString(8, CarRegtDate);
			pstmt.setString(9, CarRegtID);

			pstmt.executeUpdate();
			
			System.out.println("updateCampingcar Start!!");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // updateCampingcar()

	// updatePrevUse()
	public void updatePrevUse(int PrevUseNo, String PrevUse_LicenseID, String PrevUse_CarRegtID, String PrevUseDate) {
		String sql = "update prevuse set prevUse_LicenseID=?,prevUse_CarRegtID=?,prevUseDate=? where prevUseNo=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, PrevUse_LicenseID);
			pstmt.setString(2, PrevUse_CarRegtID);
			pstmt.setString(3, PrevUseDate);
			pstmt.setInt(4, PrevUseNo);

			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // updatePrevUse()

	// updateRental()
	public void updateRental(String RentalID, String Rental_CarRegtID, String Rental_LicenseID,
			String Rental_RentCompanyID, String RentStartDate, int RentPeriod, int RentPrice, String PaymentDue,
			String EtcBillDetail, int EtcBillPrice) {
		String sql = "update rental set rental_CarRegtID=?,rental_LicenseID=?,rental_RentCompanyID=?,rentStartDate=?,rentPeriod=?,rentPrice=?,paymentDue=?,etcBillDetail=?,etcBillPrice=? where rentalID=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Rental_CarRegtID);
			pstmt.setString(2, Rental_LicenseID);
			pstmt.setString(3, Rental_RentCompanyID);
			pstmt.setString(4, RentStartDate);
			pstmt.setInt(5, RentPeriod);
			pstmt.setInt(6, RentPrice);
			pstmt.setString(7, PaymentDue);
			pstmt.setString(8, EtcBillDetail);
			pstmt.setInt(9, EtcBillPrice);
			pstmt.setString(10, RentalID);

			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // updateRental()

	// updateRentCorp()
	public void updateRentCorp(String RentCorpID, String CorpName, String City, String Ku, String Dong,
			String CorpPhoneNum, String CorpManagerName, String CorpManagerMail) {
		String sql = "update rentcorp set corpName=?,city=?,ku=?,dong=?,corpPhoneNum=?,corpManagerName=?,corpManagerMail=? where rentCorpID=?";
		PreparedStatement pstmt = null;

		System.out.println("@@@@@@@@@@@@@@");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, CorpName);
			pstmt.setString(2, City);
			pstmt.setString(3, Ku);
			pstmt.setString(4, Dong);
			pstmt.setString(5, CorpPhoneNum);
			pstmt.setString(6, CorpManagerName);
			pstmt.setString(7, CorpManagerMail);
			pstmt.setString(8, RentCorpID);

			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // updateRentCorp()

	// updateRepair()
	public void updateRepair(int RepairID, String Repair_CarRegtID, String Repair_ShopID, String Repair_RentCompanyID,
			String Repair_LicenseID, String RepairHistory, String RepairDate, int RepairPrice, String PaymentDue,
			String EtcRepairInfo) {
		String sql = "update repair set repair_CarRegtID=?,repair_ShopID=?,repair_RentCompanyID=?,repair_LicenseID=?,repairHistory=?,repairDate=?,repairPrice=?,paymentDue=?,etcRepairInfo=? where repairID=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, Repair_CarRegtID);
			pstmt.setString(2, Repair_ShopID);
			pstmt.setString(3, Repair_RentCompanyID);
			pstmt.setString(4, Repair_LicenseID);
			pstmt.setString(5, RepairHistory);
			pstmt.setString(6, RepairDate);
			pstmt.setInt(7, RepairPrice);
			pstmt.setString(8, PaymentDue);
			pstmt.setString(9, EtcRepairInfo);
			pstmt.setInt(10, RepairID);

			pstmt.executeUpdate();
			
			System.out.println("@@!!");
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // updateRepair()

	// updateRepairShop()
	public void updateRepairShop(String ShopID, String ShopName, String City, String Ku, String Dong,
			String ShopPhoneNum, String ShopManagerName, String ShopManagerMail) {
		String sql = "update repairShop set shopName=?,city=?,ku=?,dong=?,shopPhoneNum=?,shopManagerName=?,shopManagerMail=? where shopID=?";
		PreparedStatement pstmt = null;

		System.out.println("dddddddd");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ShopName);
			pstmt.setString(2, City);
			pstmt.setString(3, Ku);
			pstmt.setString(4, Dong);
			pstmt.setString(5, ShopPhoneNum);
			pstmt.setString(6, ShopManagerName);
			pstmt.setString(7, ShopManagerMail);
			pstmt.setString(8, ShopID);

			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // updateRepairShop()

	// ------------------------------INIT------------------------------------//

	public void initAll() {
		String sql = "truncate table campingcar";
		// 테이블 안의 튜플들 싹 지우고 용량, 인덱스 모두 삭제되는 sql문
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		sql = "truncate table customer";

		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		sql = "truncate table rentCorp";

		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		sql = "truncate table rental";

		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		sql = "truncate table repair";

		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		sql = "truncate table repairshop";

		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		sql = "truncate table prevuse";

		pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// initCustomer()
	public void initCustomer() {
		System.out.println("bonobono");
		String sql;
		// 테이블 안의 튜플들 싹 지우고 용량, 인덱스 모두 삭제되는 sql문

		PreparedStatement pstmt = null;
		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('14-000001-10','Kimyejoon','Seoul','Jongnogu','Hyojadong','010-1234-1234','hong@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('07-222222-20','Leedoyun','Busan','Sahagu','Hadandong','010-1313-1313','siva@hanmail.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('12-084384-30','Parkjihoo','Busan','Sasanggu','Moradong','010-1212-1212','jobs@gmail.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('99-020756-00','Shinjiho','Daegu','Bukgu','Joyadong','010-1515-1515','dongil@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('02-041750-90','Yunseojun','Daegu','Namgu','Bongduckdong','010-1414-1414','dongk@hanmail.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('03-009730-40','Hwangseoyeon','Daegu','Donggu','Shinamdong','010-1616-1616','juju@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('09-612301-70','Parkjimin','Busan','Haeundaegu','Bansongdong','010-1717-1717','eunji29@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('12-123456-12','Leejia','Seoul','Seongbukgu','Seongbukdong','010-1818-1818','eydgns@gmail.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('13-097812-30','Kimminseo','Seoul','Dobonggu','Banghakdong','010-1919-1919','eunju@gmail.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('18-234567-80','Jeongjuho','Seoul','Gangnamgu','Samsungdong','010-2020-2020','tr29@hanmail.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('95-078492-50','Kimsuhyun','Busan','Junggu','Yeongjudong','010-2121-2121','yangkoon@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into customer(licenseID,cusName,city,ku,dong,cusPhoneNum,cusMail) values('23-150032-13','Seojina','Busan','Seogu','Nambumindong','010-2323-2323','gildong@gmail.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // initCustomer()

	// initCampingcar()
	public void initCampingcar() {

		String sql;
		// 테이블 안의 튜플들 싹 지우고 용량, 인덱스 모두 삭제되는 sql문

		PreparedStatement pstmt = null;

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20001','10003','Toyota','56SA9968',4,'http://img.hani.co.kr/imgdb/resize/2017/0920/00502866_20170920.JPG','A steady ride',100000,'2010-04-31')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20002','10004','Sonata','53GEO9169',3,'https://www.hyundaiusa.com/korean/images/vehicles/pages/vlp/2018/sonata/vlp/compare-jellies/2018-sonata-ltd-20t-symphony-silver.png','A clean inerior',80000,'2010-04-22')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20003','10001','Chevrolet','21JO2583',3,'http://cfile29.uf.tistory.com/image/202F114A50A365923B3502','A sweet smell',90000,'2010-03-12')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20004','10004','Kia','48BEO3712',2,'https://compphoto.incruit.com/2014/01/%EA%B8%B0%EC%95%84%EC%9E%90%EB%8F%99%EC%B0%A83.JPG','A cool air conditioner',120000,'2011-01-01')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20005','10005','Pride','18MA2278',4,'http://cfile23.uf.tistory.com/image/19725E474ED899FC021D93','Confortable seats',100000,'2009-12-11')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20006','10006','Tico','61A1099',5,'http://www.sobilife.com/news/photo/201305/1962_119_4417.jpg','A feeling of ease',150000,'2008-07-13')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20007','10007','Matiz','33YUK4010',9,'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e8/Daewoo_Matiz_front_20090920.jpg/1200px-Daewoo_Matiz_front_20090920.jpg','Comfortable camping',70000,'2008-11-19')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20008','10004','Grandeur','01GEO5000',5,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoZcZ_3Ixw0CtKmJ3UuQj8fFBxgy0UOXwXN9ZoK_imx0y0_W5o','Fun camping',110000,'2007-05-05')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20009','10009','Avante','12NU5169',5,'http://ourrentcar.com/data/file/gallery/2084202320_tpRrDHAd_c85fe0674a8fa4474d8c87481c5b68e363a5cfbb.png','Largeaccommodation',130000,'2010-03-31')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20010','10010','Volkswagen','49RO4518',4,'http://www.iautocar.co.kr/news/photo/201711/5200_30391_4311.jpg','Safe camping',60000,'2006-12-31')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20011','10007','Morning','50DEO7979',3,'http://autoimg.danawa.com/gallery/3333/20170418%20(2).jpg','Hottest camping',170000,'2011-06-12')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into campingcar(carRegtID,campingcar_rentCorpID,carName,carNum,carMaxPeopNum,carImage,carInfo,carrentCost,carRegtDate) values('20012','10012','Chairman','60LA7213',8,'http://global-autonews.com/data/file/ct_097/1@12330_1_1.jpg','Thrilling camping',140000,'2009-09-09')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // initCampingcar()

	// initRepairshop()
	public void initRepairshop() {

		String sql;
		// 테이블 안의 튜플들 싹 지우고 용량, 인덱스 모두 삭제되는 sql문

		PreparedStatement pstmt = null;

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS001','aashop','Seoul','Gwangjingu','Gungadong','02-111-1111','Parkseojun','psj@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS002','bbshop','Seoul','Eunpyeonggu','Bulgwangdong','02-222-2222','Choihongman','chm@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS003','ccshop','Daegu','Dalseogu','seongdangdong','02-333-3333','Jeonghaein','jhi@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS004','ddshop','Daegu','Suseonggu','Beomeodong','02-444-4444','Yujeong','yj@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS005','eeshop','Busan','Yeongdogu','Cheonghagdong','02-555-5555','Kimgoeun','kge@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS006','ffshop','Seoul','Dongjakgu','Sangdodong','02-666-6666','Gongyu','gy@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS007','ggshop','Seoul','Gurogu','Sindorimdong','02-777-7777','Joinseong','jis@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS008','hhshop','Busan','Dongraegu','Nagmindong','02-888-8888','Chataehyeon','cth@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS009','iishop','Seoul','Gangnamgu','samsungdong','02-999-9999','Sonnaeun','sne@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS010','jjshop','Seoul','Songpagu','Gamsildong','02-123-1234','Sulhyeon','sh@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS011','kkshop','Busan','donggu','Cholyangdong','02-456-4567','Kimjunhyeon','kjh@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repairshop(shopID,shopName,city,ku,dong,shopPhoneNum,shopManagerName,shopManagerMail) values('RPS012','llshop','Seoul','Jongrogu','Cheongundong','02-789-7899','Seongdongil','sdi@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // initRepairshop()

	// initRepair()
	public void initRepair() {

		String sql;
		// 테이블 안의 튜플들 싹 지우고 용량, 인덱스 모두 삭제되는 sql문

		PreparedStatement pstmt = null;

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110001,'20002','RPS001','10004','07-222222-20','bumper','2017-02-28',50000,'2017-03-28','Request maintenance')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110002,'20001','RPS002','10003','02-041750-90','scratch','2012-04-21',40000,'2012-04-31','severe scratch')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110003,'20005','RPS003','10005','07-222222-20','motor','2014-05-01',100000,'2014-05-11','Request maintenance')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110004,'20007','RPS004','10007','23-150032-13','scratch','2013-05-30',40000,'2013-06-01','severe scratch')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110005,'20004','RPS005','10004','99-020756-00','glass','2017-05-17',70000,'2017-06-17','Request maintenance')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110006,'20002','RPS006','10004','07-222222-20','tire','2014-06-20',20000,'2014-06-21','Request maintenance')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110007,'20006','RPS007','10006','12-123456-12','scratch','2013-10-09',40000,'2013-10-11','severe scratch')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110008,'20003','RPS008','10001','09-612301-70','scratch','2017-10-09',40000,'2017-11-09','severe scratch')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110009,'20012','RPS009','10012','23-150032-13','scratch','2015-12-02',40000,'2015-12-12','severe scratch')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110010,'20009','RPS010','10009','13-097812-30','glass','2017-12-04',70000,'2018-01-04','Request maintenance')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110011,'20005','RPS011','10005','12-123456-12','glass','2014-01-05',70000,'2014-01-07','Request maintenance')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into repair(repairID,repair_carRegtID,repair_shopID,repair_rentCompanyID,repair_licenseID,repairHistory,repairDate,repairPrice,paymentDue,etcRepairInfo) values(110012,'20007','RPS012','10007','07-222222-20','scratch','2016-01-12',40000,'2016-01-19','Request maintenance')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // initRepair()

	// initRentcorp()
	public void initRentcorp() {

		String sql;
		// 테이블 안의 튜플들 싹 지우고 용량, 인덱스 모두 삭제되는 sql문

		PreparedStatement pstmt = null;

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10001','gubne','Seoul','Gwangjingu','Neungdong','02-111-1111','KimEunsuk','dkdla58@hanmail.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10002','vantech','Busan','Seogu','Bumindong','02-222-2222','ChoiGoya','np12@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10003','mymy','Daegu','Namgu','Daemyungdong','02-333-3333','OkSonghae','oksy97@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10004','sejin','Daegu','Suseonggu','Manchondong','02-444-4444','ChoiJihyun','ulul@gmail.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10005','union','Busan','Donggu','Sujungdong','02-555-5555','ParkJisung','ekfh4@hanmail.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10006','coach','Seoul','Dongjakgu','Sangdodong','02-666-1111','LeeMatae','lmt11@naver.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10007','mikuk','Seoul','Gurogu','Sindorimdong','02-777-1111','LeeHojin','lhj12@hanmail.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10008','sedo','Busan','Dongraegu','Suandong','02-888-1111','KimJuwon','dkdk3@daum.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10009','hana','Daegu','Junggu','Jeondong','02-999-1111','KimHyojin','take3@daum.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10010','okay','Seoul','Songpagu','Jamsildong','02-111-2222','KangSeungwon','makeit@gmail.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10011','caraban','Busan','Suyeonggu','Mangmidong','02-111-3333','KimMira','el10@gmail.com')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rentcorp(rentCorpID,corpName,city,ku,dong,corpPhoneNum,corpManagerName,corpManagerMail) values('10012','dana','Busan','Geumjunggu','Namsandong','02-111-4444','KimPodo','heyhi@hanmail.net')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // initRentcorp()

	// initRental()
	public void initRental() {

		String sql;
		// 테이블 안의 튜플들 싹 지우고 용량, 인덱스 모두 삭제되는 sql문

		PreparedStatement pstmt = null;

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0001','20007','14-000001-10','10007','2017-01-21',3,210000,'2017-01-30','induction',20000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0002','20002','07-222222-20','10004','2017-02-24',4,320000,'2017-03-05','induction',20000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0003','20011','12-084384-30','10007','2017-04-16',2,340000,'2017-04-25','kingsize bed',50000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0004','20004','99-020756-00','10004','2017-05-03',1,120000,'2017-05-10','induction',20000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0005','20005','02-041750-90','10005','2017-07-02',5,500000,'2017-07-13','kingsize bed',50000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0006','20002','03-009730-40','10004','2017-08-23',2,160000,'2017-08-31','kingsize bed',50000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0007','20003','09-612301-70','10001','2017-09-11',11,990000,'2017-09-28','induction',20000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0008','20008','12-123456-12','10004','2017-10-05',7,770000,'2017-10-18','kingsize bed',50000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0009','20009','13-097812-30','10009','2017-10-31',30,3900000,'2017-12-05','induction',20000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0010','20010','18-234567-80','10010','2017-11-11',3,180000,'2017-11-20','kingsize bed',50000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0011','20002','95-078492-50','10004','2017-12-24',1,80000,'2017-12-31','induction',20000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into rental(rentalID,rental_carRegtID,rental_licenseID,rental_rentCompanyID,rentStartDate,rentPeriod,rentPrice,paymentDue,etcBillDetail,etcBillPrice) values('RT0012','20012','23-150032-13','10012','2017-12-25',4,560000,'2018-01-05','kingsize bed',50000)";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // initRental()

	// initPrevuse()
	public void initPrevuse() {

		String sql;
		// 테이블 안의 튜플들 싹 지우고 용량, 인덱스 모두 삭제되는 sql문

		PreparedStatement pstmt = null;

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123001,'14-000001-10','20004','2016-03-01')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123002,'07-222222-20','20005','2015-04-16')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123003,'12-084384-30','20004','2011-11-12')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123004,'14-000001-10','20001','2013-03-14')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123005,'07-222222-20','20002','2015-07-31')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123006,'23-150032-13','20009','2010-11-11')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123007,'09-612301-70','20005','2012-02-14')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123008,'12-084384-30','20010','2015-06-24')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123009,'14-000001-10','20001','2011-05-05')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123010,'12-084384-30','20012','2014-08-22')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123011,'95-078492-50','20011','2016-01-01')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		sql = "insert into prevuse(prevUseNo,prevUse_licenseID,prevUse_carRegtID,prevUseDate) values(123012,'14-000001-10','20004','2013-04-04')";
		pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // initPrevUse()
}// DatabaseConnect

class DescribeTableVO {
	private String column_name;

	public DescribeTableVO(String column_name) {
		super();
		this.column_name = column_name;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	@Override
	public String toString() {
		return "DescribeTableVO [column_name=" + column_name + "]";
	}

}// DescribeTableVO

// CustomerVO()
class CustomerVO {
	private String licenseID;
	private String cusName;
	private String city;
	private String ku;
	private String dong;
	private String cusPhoneNum;
	private String cusMail;

	public CustomerVO(String licenseID, String cusName) {
		super();
		this.licenseID = licenseID;
		this.cusName = cusName;
	}

	public CustomerVO(String licenseID, String cusName, String city, String ku, String dong, String cusPhoneNum,
			String cusMail) {
		super();
		this.licenseID = licenseID;
		this.cusName = cusName;
		this.city = city;
		this.ku = ku;
		this.dong = dong;
		this.cusPhoneNum = cusPhoneNum;
		this.cusMail = cusMail;

	}

	public String getLicenseID() {
		return licenseID;
	}

	public void setlicenseID(String licenseID) {
		this.licenseID = licenseID;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public String getKu() {
		return ku;
	}

	public void setku(String ku) {
		this.ku = ku;
	}

	public String getDong() {
		return dong;
	}

	public void setdong(String dong) {
		this.dong = dong;
	}

	public String getCusPhoneNum() {
		return cusPhoneNum;
	}

	public void setcusPhoneNum(String cusPhoneNum) {
		this.cusPhoneNum = cusPhoneNum;
	}

	public String getCusMail() {
		return cusMail;
	}

	public void setcusMail(String cusMail) {
		this.cusMail = cusMail;
	}

	@Override
	public String toString() {
		return "CustomerVO [licenseID=" + licenseID + ", cusName=" + cusName + ", city=" + city + ", ku=" + ku
				+ ", dong=" + dong + ", cusPhoneNum=" + cusPhoneNum + ", cusMail=" + cusMail + "]";
	}

} // CustomerVO()

// CampingcarVO()
class CampingcarVO {
	private String carRegtID;
	private String campingcar_RentCorpID;
	private String carName;
	private String carNum;
	private int carMaxPeopNum;
	private String carImage;
	private String carInfo;
	private int carRentCost;
	private String carRegtDate;

	public CampingcarVO() {

	}

	public CampingcarVO(String carRegtID, String campingcar_RentCorpID, String carName, String carNum,
			int carMaxPeopNum, String carImage, String carInfo, int carRentCost, String carRegtDate) {
		super();
		this.carRegtID = carRegtID;
		this.campingcar_RentCorpID = campingcar_RentCorpID;
		this.carName = carName;
		this.carNum = carNum;
		this.carMaxPeopNum = carMaxPeopNum;
		this.carImage = carImage;
		this.carInfo = carInfo;
		this.carRentCost = carRentCost;
		this.carRegtDate = carRegtDate;
	}

	public String getCarRegtID() {
		return carRegtID;
	}

	public void setCarRegtID(String carRegtID) {
		this.carRegtID = carRegtID;
	}

	public String getCampingcar_RentCorpID() {
		return campingcar_RentCorpID;
	}

	public void setcampingcar_RentCorpID(String campingcar_RentCorpID) {
		this.campingcar_RentCorpID = campingcar_RentCorpID;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public int getCarMaxPeopNum() {
		return carMaxPeopNum;
	}

	public void setCarMaxPeopNum(int carMaxPeopNum) {
		this.carMaxPeopNum = carMaxPeopNum;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	public int getCarRentCost() {
		return carRentCost;
	}

	public void setcarRentCost(int carRentCost) {
		this.carRentCost = carRentCost;
	}

	public String getCarRegtDate() {
		return carRegtDate;
	}

	public void setCarRegtDate(String carRegtDate) {
		this.carRegtDate = carRegtDate;
	}

	@Override
	public String toString() {
		return "CampingcarVO [carRegtID=" + carRegtID + ", campingcar_RentCorpID=" + campingcar_RentCorpID
				+ ", carName=" + carName + ", carNum=" + carNum + ", carMaxPeopNum=" + carMaxPeopNum + ", carImage="
				+ carImage + ", carInfo=" + carInfo + ", carRentCost=" + carRentCost + ", carRegtDate=" + carRegtDate
				+ "]";
	}

}// CampingcarVO

// RentalVO()
class RentalVO {
	private String rentalID;
	private String rental_CarRegtID;
	private String rental_LicenseID;
	private String rental_RentCompanyID;
	private String rentStartDate;
	private int rentPeriod;
	private int rentPrice;
	private String paymentDue;
	private String etcBillDetail;
	private int etcBillPrice;

	public RentalVO() {

	}

	public RentalVO(String rentalID, String rental_CarRegtID, String rental_LicenseID, String rental_RentCompanyID,
			String rentStartDate, int rentPeriod, int rentPrice, String paymentDue, String etcBillDetail,
			int etcBillPrice) {

		super();

		this.rentalID = rentalID;
		this.rental_CarRegtID = rental_CarRegtID;
		this.rental_LicenseID = rental_LicenseID;
		this.rental_RentCompanyID = rental_RentCompanyID;
		this.rentStartDate = rentStartDate;
		this.rentPeriod = rentPeriod;
		this.rentPrice = rentPrice;
		this.paymentDue = paymentDue;
		this.etcBillDetail = etcBillDetail;
		this.etcBillPrice = etcBillPrice;

	}

	public String getRentalID() {
		return rentalID;
	}

	public void setrentalID(String rentalID) {
		this.rentalID = rentalID;
	}

	public String getRental_CarRegtID() {
		return rental_CarRegtID;
	}

	public void setrental_CarRegtID(String rental_CarRegtID) {
		this.rental_CarRegtID = rental_CarRegtID;
	}

	public String getRental_LicenseID() {
		return rental_LicenseID;
	}

	public void setrental_LicenseID(String rental_LicenseID) {
		this.rental_LicenseID = rental_LicenseID;
	}

	public String getRental_RentCompanyID() {
		return rental_RentCompanyID;
	}

	public void setrental_RentCompanyID(String rental_RentCompanyID) {
		this.rental_RentCompanyID = rental_RentCompanyID;
	}

	public String getRentStartDate() {
		return rentStartDate;
	}

	public void setRentStartDate(String rentStartDate) {
		this.rentStartDate = rentStartDate;
	}

	public int getRentPeriod() {
		return rentPeriod;
	}

	public void setRentPeriod(int rentPeriod) {
		this.rentPeriod = rentPeriod;
	}

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getPaymentDue() {
		return paymentDue;
	}

	public void setPaymentDue(String paymentDue) {
		this.paymentDue = paymentDue;
	}

	public String getEtcBillDetail() {
		return etcBillDetail;
	}

	public void setEtcBillDetail(String etcBillDetail) {
		this.etcBillDetail = etcBillDetail;
	}

	public int getEtcBillPrice() {
		return etcBillPrice;
	}

	public void setEtcBillPrice(int etcBillPrice) {
		this.etcBillPrice = etcBillPrice;
	}

} // RentalVO()

// PrevUseVO()
class PrevUseVO {

	private int prevUseNo;
	private String prevUse_LicenseID;
	private String prevUse_CarRegtID;
	private String prevUseDate;

	public PrevUseVO() {

	}

	public PrevUseVO(int prevUseNo, String prevUse_LicenseID, String prevUse_CarRegtID, String prevUseDate) {
		super();
		this.prevUseNo = prevUseNo;
		this.prevUse_LicenseID = prevUse_LicenseID;
		this.prevUse_CarRegtID = prevUse_CarRegtID;
		this.prevUseDate = prevUseDate;
	}

	public int getPrevUseNo() {
		return prevUseNo;
	}

	public void setPrevUseNo(int prevUseNo) {
		this.prevUseNo = prevUseNo;
	}

	public String getPrevUse_LicenseID() {
		return prevUse_LicenseID;
	}

	public void setPrevUse_LicenseID(String prevUse_LicenseID) {
		this.prevUse_LicenseID = prevUse_LicenseID;
	}

	public String getPrevUse_CarRegtID() {
		return prevUse_CarRegtID;
	}

	public void setPrevUse_CarRegtID(String prevUse_CarRegtID) {
		this.prevUse_CarRegtID = prevUse_CarRegtID;
	}

	public String getPrevUseDate() {
		return prevUseDate;
	}

	public void setPrevUseDate(String prevUseDate) {
		this.prevUseDate = prevUseDate;
	}

} // PrevUseVO()

// RentCorpVO()
class RentCorpVO {
	private String rentCorpID;
	private String corpName;
	private String city;
	private String ku;
	private String dong;
	private String corpPhoneNum;
	private String corpManagerName;
	private String corpManagerMail;

	public RentCorpVO() {

	}

	public RentCorpVO(String rentCorpID, String corpName, String city, String ku, String dong, String corpPhoneNum,
			String corpManagerName, String corpManagerMail) {
		super();
		this.rentCorpID = rentCorpID;
		this.corpName = corpName;
		this.city = city;
		this.ku = ku;
		this.dong = dong;
		this.corpPhoneNum = corpPhoneNum;
		this.corpManagerName = corpManagerName;
		this.corpManagerMail = corpManagerMail;

	}

	public String getRentCorpID() {
		return rentCorpID;
	}

	public void setRentCorpID(String rentCorpID) {
		this.rentCorpID = rentCorpID;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getKu() {
		return ku;
	}

	public void setKu(String ku) {
		this.ku = ku;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getCorpPhoneNum() {
		return corpPhoneNum;
	}

	public void setCorpPhoneNum(String corpPhoneNum) {
		this.corpPhoneNum = corpPhoneNum;
	}

	public String getCorpManagerName() {
		return corpManagerName;
	}

	public void setCorpManagerName(String corpManagerName) {
		this.corpManagerName = corpManagerName;
	}

	public String getCorpManagerMail() {
		return corpManagerMail;
	}

	public void setCorpManagerMail(String corpManagerMail) {
		this.corpManagerMail = corpManagerMail;
	}

} // RentCorpVO()

// RepairShopVO()
class RepairShopVO {
	private String shopID;
	private String shopName;
	private String city;
	private String ku;
	private String dong;
	private String shopPhoneNum;
	private String shopManagerName;
	private String shopManagerMail;

	public RepairShopVO() {

	}

	public RepairShopVO(String shopID, String shopName, String city, String ku, String dong, String shopPhoneNum,
			String shopManagerName, String shopManagerMail) {
		super();
		this.shopID = shopID;
		this.shopName = shopName;
		this.city = city;
		this.ku = ku;
		this.dong = dong;
		this.shopPhoneNum = shopPhoneNum;
		this.shopManagerName = shopManagerName;
		this.shopManagerMail = shopManagerMail;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getKu() {
		return ku;
	}

	public void setKu(String ku) {
		this.ku = ku;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getShopPhoneNum() {
		return shopPhoneNum;
	}

	public void setShopPhoneNum(String shopPhoneNum) {
		this.shopPhoneNum = shopPhoneNum;
	}

	public String getShopManagerName() {
		return shopManagerName;
	}

	public void setShopManagerName(String shopManagerName) {
		this.shopManagerName = shopManagerName;
	}

	public String getShopManagerMail() {
		return shopManagerMail;
	}

	public void setShopManagerMail(String shopManagerMail) {
		this.shopManagerMail = shopManagerMail;
	}

} // RepairShopVO()

// RepairVO()
class RepairVO {
	private int repairID;
	private String repair_CarRegtID;
	private String repair_ShopID;
	private String repair_RentCompanyID;
	private String repair_LicenseID;
	private String repairHistory;
	private String repairDate;
	private int repairPrice;
	private String paymentDue;
	private String etcRepairInfo;

	public RepairVO() {

	}

	public RepairVO(int repairID, String repair_CarRegtID, String repair_ShopID, String repair_RentCompanyID,
			String repair_LicenseID, String repairHistory, String repairDate, int repairPrice, String paymentDue,
			String etcRepairInfo) {
		super();
		this.repairID = repairID;
		this.repair_CarRegtID = repair_CarRegtID;
		this.repair_ShopID = repair_ShopID;
		this.repair_RentCompanyID = repair_RentCompanyID;
		this.repair_LicenseID = repair_LicenseID;
		this.repairHistory = repairHistory;
		this.repairDate = repairDate;
		this.repairPrice = repairPrice;
		this.paymentDue = paymentDue;
		this.etcRepairInfo = etcRepairInfo;
	}

	public int getRepairID() {
		return repairID;
	}

	public void setRepairID(int repairID) {
		this.repairID = repairID;
	}

	public String getRepair_CarRegtID() {
		return repair_CarRegtID;
	}

	public void setRepair_CarRegtID(String repair_CarRegtID) {
		this.repair_CarRegtID = repair_CarRegtID;
	}

	public String getRepair_ShopID() {
		return repair_ShopID;
	}

	public void setRepair_ShopID(String repair_ShopID) {
		this.repair_ShopID = repair_ShopID;
	}

	public String getRepair_RentCompanyID() {
		return repair_RentCompanyID;
	}

	public void setRepair_RentCompanyID(String repair_RentCompanyID) {
		this.repair_RentCompanyID = repair_RentCompanyID;
	}

	public String getRepair_LicenseID() {
		return repair_LicenseID;
	}

	public void setRepair_LicenseID(String repair_LicenseID) {
		this.repair_LicenseID = repair_LicenseID;
	}

	public String getRepairHistory() {
		return repairHistory;
	}

	public void setRepairHistory(String repairHistory) {
		this.repairHistory = repairHistory;
	}

	public String getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}

	public int getRepairPrice() {
		return repairPrice;
	}

	public void setRepairPrice(int repairPrice) {
		this.repairPrice = repairPrice;
	}

	public String getPaymentDue() {
		return paymentDue;
	}

	public void setPaymentDue(String paymentDue) {
		this.paymentDue = paymentDue;
	}

	public String getEtcRepairInfo() {
		return etcRepairInfo;
	}

	public void setEtcRepairInfo(String etcRepairInfo) {
		this.etcRepairInfo = etcRepairInfo;
	}

} // RepairVO()

// @@@
// FreqRepairCustomerVO()
class FreqRepairCustomerVO {
	private String licenseID;
	private String cusName;

	public FreqRepairCustomerVO() {

	}

	public FreqRepairCustomerVO(String licenseID, String cusName) {
		super();
		this.licenseID = licenseID;
		this.cusName = cusName;

	}

	public String getLicenseID() {
		return licenseID;
	}

	public void setLicenseID(String licenseID) {
		this.licenseID = licenseID;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
}

// @@@
// CountRentalVO()
class CountRentalVO {
	private String prevUse_licenseID;
	private int count;

	public CountRentalVO() {

	}

	public CountRentalVO(String prevUse_licenseID, int count) {
		super();
		this.prevUse_licenseID = prevUse_licenseID;
		this.count = count;

	}

	public String getPrevUse_licenseID() {
		return prevUse_licenseID;
	}

	public void setPrevUse_licenseID(String prevUse_licenseID) {
		this.prevUse_licenseID = prevUse_licenseID;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}

// @@@
// RepairShopLocVO()
class RepairShopLocVO {
	private String city;
	private int count;

	public RepairShopLocVO() {

	}

	public RepairShopLocVO(String city, int count) {
		super();
		this.city = city;
		this.count = count;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}

// @@@
// AvgCarRentCostVO()
class AvgCarRentCostVO {
	private int carMaxPeopnum;
	private int avg_carrentCost;

	public AvgCarRentCostVO() {

	}

	public AvgCarRentCostVO(int carMaxPeopnum, int avg_carrentCost) {
		super();
		this.carMaxPeopnum = carMaxPeopnum;
		this.avg_carrentCost = avg_carrentCost;
	}

	public int getCarMaxPeopnum() {
		return carMaxPeopnum;
	}

	public void setCarMaxPeopnum(int carMaxPeopnum) {
		this.carMaxPeopnum = carMaxPeopnum;
	}

	public int getAvg_carrentCost() {
		return avg_carrentCost;
	}

	public void setAvg_carrentCost(int avg_carrentCost) {
		this.avg_carrentCost = avg_carrentCost;
	}
}



