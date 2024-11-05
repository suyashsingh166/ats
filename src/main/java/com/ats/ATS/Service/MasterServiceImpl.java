package com.ats.ATS.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.DesignationRepo;
import com.ats.ATS.Repository.LocationRepo;
import com.ats.ATS.Repository.QualificationRepo;
import com.ats.ATS.Repository.RoundRepo;
import com.ats.ATS.model.DesignationMaster;
import com.ats.ATS.model.LocationMaster;
import com.ats.ATS.model.PriviligeModel;
import com.ats.ATS.model.QualificationMaster;
import com.ats.ATS.model.RoundsMaster;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class MasterServiceImpl implements MasterService {

	 @PersistenceContext
	    private EntityManager entityManager;
	
	@Autowired
	private DesignationRepo designation;
	
	@Autowired
	private LocationRepo location;
	
	@Autowired
	private QualificationRepo qauli;
	
	@Autowired
	private RoundRepo round;
	
	@Override
	public String designationname(String designations) {
		// TODO Auto-generated method stub
		return designation.designationname(designations);
	}

	@Override
	public DesignationMaster saveDesignation(DesignationMaster desig) {
		// TODO Auto-generated method stub
		return designation.save(desig);
	}

	@Override
	public List<DesignationMaster> getAllDesignation() {
		// TODO Auto-generated method stub
		return designation.findAll();
	}

	@Override
	public void deleteDesignation(int id) {
		// TODO Auto-generated method stub
		designation.deleteById(id);
	}

	@Override
	public LocationMaster saveLocation(LocationMaster locat) {
		// TODO Auto-generated method stub
		return location.save(locat);
	}

	@Override
	public List<LocationMaster> getAllLocation() {
		// TODO Auto-generated method stub
		return location.findAll();
	}

	@Override
	public String locationnname(String locations) {
		// TODO Auto-generated method stub
		return location.locationnname(locations);
	}

	@Override
	public void deleteLocation(int id) {
		// TODO Auto-generated method stub
		location.deleteById(id);
	}

	@Override
	public QualificationMaster saveQualification(QualificationMaster quali) {
		// TODO Auto-generated method stub
		return qauli.save(quali);
	}

	@Override
	public List<QualificationMaster> getAllQualification() {
		// TODO Auto-generated method stub
		return qauli.findAll();
	}

	@Override
	public String qualification(String qualification) {
		// TODO Auto-generated method stub
		return qauli.qualification(qualification);
	}

	@Override
	public void deleteQualification(int id) {
		// TODO Auto-generated method stub
		qauli.deleteById(id);
	}

	@Override
	public Integer noOfRounds(Integer no_of_rounds) {
		// TODO Auto-generated method stub
		return round.noOfRounds(no_of_rounds);
	}

	@Override
	public List<RoundsMaster> getAllRounds() {
		// TODO Auto-generated method stub
		return round.findAll();
	}

	@Override
	public void deleteRounds(int id) {
		// TODO Auto-generated method stub
		round.deleteById(id);
	}

	@Override
	public RoundsMaster saveRounds(RoundsMaster rounds) {
		// TODO Auto-generated method stub
		return round.save(rounds);
	}

	@Override
	@Transactional
	public void updateRound(Integer id, RoundsMaster round) {
		// TODO Auto-generated method stub
		RoundsMaster existingEntity = entityManager.find(RoundsMaster.class, id);
        if (existingEntity != null) {
            existingEntity.setNo_of_rounds(round.getNo_of_rounds());
            existingEntity.setCreated_date(round.getCreated_date());
            // Set other properties as needed
            entityManager.merge(existingEntity);
	}

}

	@Override
	public Date getcreateDate(Integer id) {
		// TODO Auto-generated method stub
		return round.getcreateDate(id);
	}

	

	@Override
	@Transactional
	public void updateQualification(Integer id, QualificationMaster quali) {
		// TODO Auto-generated method stub
		QualificationMaster existingEntity = entityManager.find(QualificationMaster.class, id);
		        if (existingEntity != null) {
		            existingEntity.setQualification(quali.getQualification());
		            existingEntity.setCreated_date(quali.getCreated_date());
		            // Set other properties as needed
		            entityManager.merge(existingEntity);
			}
}

	@Override
	public Date getcreateDateQuali(Integer id) {
		// TODO Auto-generated method stub
		return qauli.getcreateDateQuali(id);
	}

	@Override
	public Date getcreateDateLoc(Integer id) {
		// TODO Auto-generated method stub
		return location.getcreateDateLoc(id);
	}

	@Override
	@Transactional
	public void updateLocation(Integer id, LocationMaster locat) {
		// TODO Auto-generated method stub
		LocationMaster existingEntity = entityManager.find(LocationMaster.class, id);
        if (existingEntity != null) {
            existingEntity.setLocation(locat.getLocation());
            existingEntity.setCreated_date(locat.getCreated_date());
            // Set other properties as needed
            entityManager.merge(existingEntity);
	}
}

	@Override
	public Date getcreateDateDesignation(Integer id) {
		// TODO Auto-generated method stub
		return designation.getcreateDateDesignation(id);
	}

	@Override
	@Transactional
	public void updateDesignation(Integer id, DesignationMaster desig) {
		DesignationMaster existingEntity = entityManager.find(DesignationMaster.class, id);
        if (existingEntity != null) {
            existingEntity.setDesignation(desig.getDesignation());
            existingEntity.setCreated_date(desig.getCreated_date());
            // Set other properties as needed
            entityManager.merge(existingEntity);
	}
	}

	public Integer finddesignationid(String department) {
		
		return designation.findAllById(department);
	}


}
