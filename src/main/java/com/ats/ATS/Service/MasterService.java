package com.ats.ATS.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ATS.model.DesignationMaster;
import com.ats.ATS.model.LocationMaster;
import com.ats.ATS.model.PriviligeModel;
import com.ats.ATS.model.QualificationMaster;
import com.ats.ATS.model.RoundsMaster;

public interface MasterService {

	String designationname(String designation);

	public DesignationMaster saveDesignation(DesignationMaster desig);
    public Integer finddesignationid(String department);
	List<DesignationMaster> getAllDesignation();

	public void deleteDesignation(int id);

	public LocationMaster saveLocation(LocationMaster locat);

	List<LocationMaster> getAllLocation();

	String locationnname(String location);

	public void deleteLocation(int id);

	public QualificationMaster saveQualification(QualificationMaster quali);

	List<QualificationMaster> getAllQualification();

	String qualification(String qualification);

	public void deleteQualification(int id);

	Integer noOfRounds(Integer no_of_rounds);

	List<RoundsMaster> getAllRounds();

	void deleteRounds(int id);

	public RoundsMaster saveRounds(RoundsMaster round);

	void updateRound(Integer id, RoundsMaster round);

	Date getcreateDate(Integer id);


	public void updateQualification(Integer id, QualificationMaster quali);

	Date getcreateDateQuali(Integer id);

	Date getcreateDateLoc(Integer id);

	public void updateLocation(Integer id, LocationMaster locat);

	Date getcreateDateDesignation(Integer id);

	void updateDesignation(Integer id, DesignationMaster desig);

}
