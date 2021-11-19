package in.cmss.icici.uotm.identity.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cmss.icici.uotm.identity.vo.Employee;
import in.cmss.icici.uotm.identity.vo.EmployeeOffice;
import in.cmss.icici.uotm.identity.vo.device.RegisteredDeviceVO;
import in.cmss.icici.uotm.identity.vo.login.LoginResponseVO;

@Service
public class IdentityServiceFactory {

	@Autowired
	BiometricsIdentityService biometricsIdentityService;

	@Autowired
	MPinIdentityService mPinIdentityService;

	@Autowired
	PassowrdIdentityService passowrdIdentityService;

	public IdentityService get(String type) {
		switch (type) {
		case "bio":
			return biometricsIdentityService;
		case "pin":
			return mPinIdentityService;
		case "web":
		default:
			return passowrdIdentityService;
		}
	}

	private static final List<String> DEFAULT_MAC = Arrays.asList("MT_HST", "ESO_MGR",
			"SETT", "EXP_BRN_MGR", "PRO_APP", "EXP_HST", "ADDT_INC", "MY_FIN_PF",
			"FSO_APP", "ATM_BRCH", "HOL_CAL", "TAX_CAL", "INV_RENT", "ESO_HIST", "EGES",
			"MC_EGN", "MC_BFT", "GST_MGR", "MC_MWL", "LV_APP", "ESO_APP", "EXP_OFC_APPLY",
			"PRO_ASST_DTL", "FSO_HIST", "OFR_OTHR", "AT_CORP", "EXP_TRVL_APP", "LP_UPD",
			"INV_MGR", "LV_MGR", "INV_LOS_PROP", "EXP_TRVL_MGR", "LV_APY",
			"INV_DECL_80CC", "MASSIST", "COVID_DISCLSR", "LD_CREATE", "FR_NTF", "DNA_MGR",
			"ESO_UPD", "INV_DECL_ADDT_INC", "MT_MGR", "LP_HIST", "EXP_FD_APP", "DE_REG",
			"INV_80CC", "MORTGAGE_OFFERS", "MORTGAGE_EMPLOYEE_BENEFITS", "INV_PET_BIL",
			"ATM_CNTR", "INV_DECL_NPS", "AT_GR", "APPROVAL_CARD", "LD_MGR", "OFR_CAR",
			"EXP_MGR", "MC_HSP", "LP_APP", "INV_TEL_BIL", "TRVL_APP", "MC_AMB",
			"INV_DECL_STAFF_HSG", "ABT_ME", "UHID_GROUP", "PRO_ASST_ACK", "LV_BAL",
			"LV_HST", "PMS_MGR", "INV_DECL_RENT", "EXP_OFC_MGR", "MY_FIN_SUP", "LV_TCL",
			"DNA_AWRD", "LP_MGR", "MT_UPL", "EXP_APY", "VPF", "CHT_BOT", "INV_LTA",
			"INV_DECL_OTH", "EXP_FD_MGR", "OFR_MGR", "SL_SLP", "MY_TM", "OFR_HOME",
			"EXP_BRN_APP", "TALK_HR_test", "test_INV_DECL_MGR", "MC_PDT", "ESEN_SRV",
			"RESIGN_MGR", "INV_GUID_FAQ", "INV_OTH", "AT_PR", "EXP_STS", "RESIGN_SGN_OFF",
			"FDBK_360", "VCLAIM_APR", "INSTA", "INV_DECL_VPF", "FSO_MGR", "STAFF_HSG",
			"RST", "MY_FIN_GRA", "BRCH_LOC", "FIN_FORM16", "NTFN_CNT", "NEES", "HR_BOT",
			"MY_FIN", "VCLAIM_STS", "INV_ADD_IN", "LD_DTL", "HARI_NM", "EXP_OFC_STATUS",
			"FSO_UPD", "INV_DECL_MGR", "MY_APR", "ICE_TM",
			"MORTGAGE_PREAPPROVED_BENEFITS", "MC_PTH", "EXP_OFC_APP", "PAR_POL",
			"RESIGN_RA", "INV_DECL_LTA", "INV_TX", "MT_APP", "TMS_MGR", "BSC_MGR",
			"UHID_MGR", "K_BOT", "EXP_APP");

	public static Employee employee() {
		return Employee.builder()
				.grade(290)
				.id(250282)
				.name("Ayush Kedia")
				.userID("250282")
				.type("M")
				.build();
	}

	public static EmployeeOffice employeeOffice() {
		return EmployeeOffice.builder()
				.from(LocalTime.of(10, 0))
				.to(LocalTime.of(18, 0))
				.latitude(19.1868593f)
				.longitude(72.8345877f)
				.state("West")
				.build();
	}

	public static LoginResponseVO sample() {
		return LoginResponseVO.builder()
				.employee(employee())
				.lastLoginTime(LocalDateTime.of(LocalDate.now(), LocalTime.now()))
				.menuAuthCodes(DEFAULT_MAC)
				.office(employeeOffice())
				.build();
	}

	public static List<RegisteredDeviceVO> devices() {
		RegisteredDeviceVO device1 = RegisteredDeviceVO.builder()
				.employeeId("250282")
				.id("02326f9e0199767b")
				.model("Google,Android SDK built for x86")
				.notificationId(
						"c1fbt0PHQao:APA91bF8tknpA8GAod2JLfUiZp11r2ZKcU1Ztq75LMoRZzSz2cO5WF8wyDjyJcB1PDAY3EJ7iVKctJ_rlT1AXviM2JvOu6k3NrF7BD4GDK6VJ6BZcqkgJLLQhUY1-e9Um-UaMynQibVt")
				.type("A")
				.build();

		RegisteredDeviceVO device2 = RegisteredDeviceVO.builder()
				.employeeId("250282")
				.id("094F151E-0979-4ED9-AADC-7BDA6A24441F")
				.model("Simulator iPhone12,1")
				.notificationId(
						"eUxA804glmI:APA91bHhG2JOwotzBcY2JsaZy7FbjG0GPe0iI4HI97Hw4Iw2nGmEn585WhCzZGi8sbot7i9OGckR9wgUh_c_sp6fnuSCvBTExL_le9Q3WJiuq_U3MPk1OQZcH_vHKSy6RRN4-J6JZhN3")
				.type("I")
				.build();

		return Arrays.asList(device1, device2);
	}
}
