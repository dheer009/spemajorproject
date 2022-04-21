package com.project.maintenant.services;

import com.project.maintenant.model.entities.Mentee;
import com.project.maintenant.model.entities.Mentor;
import com.project.maintenant.repo.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.maintenant.repo.MenteeRepository;

import java.util.*;

@Service
public class MenteeEntityService
{
    @Autowired
    private MenteeRepository menteeRepository;
    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private MentorEntityService mentorEntityService;







    public Mentee fetchMenteeByEmailId(String email)
    {
        return menteeRepository.findByEmail(email);
    }
    public Mentee getMenteeByEmailId1(Map<String,Object> payload)
    {
        Mentee mentee = this.menteeRepository.findByEmail((String) payload.get("email"));
        return menteeRepository.findById(mentee.getId()).get();
    }
    public boolean login(Map<String, Object> payload){
        List<Mentee> menteeEntityList = menteeRepository.getByUsername((String) payload.get("username"));
        if (menteeEntityList.size()>0 &&
                menteeEntityList.get(0).getPassword().equals((String) payload.get("password"))){
            return true;
        }
        return false;
    }
    public Mentee fetchMenteeByEmailIdAndPassword(String email, String password)
    {
        return menteeRepository.findByEmailAndPassword(email,password);
    }
    public Mentee getMenteeByEmailIdAndPassword1(Map<String,Object> payload)
    {

        Mentee mentee = this.menteeRepository.findByEmail((String) payload.get("email"));
        String email = mentee.getEmail();
        String password = mentee.getPassword();
        return menteeRepository.findByEmailAndPassword(email,password);
    }
    public Mentee saveMentee(Mentee mentee)
    {
        return menteeRepository.save(mentee);
    }
    public String addMentee(Map<String, Object> payload)
    {
        try
        {
            Mentee mentee = new Mentee();
            System.out.println("In add mentee service");
            System.out.println("payload username "+(String) payload.get("username"));
            mentee.setUsername((String) payload.get("username"));
            mentee.setPassword((String) payload.get("password"));
            mentee.setFirstName((String) payload.get("firstName"));
            mentee.setFirstName((String) payload.get("lastName"));

            System.out.println("addline "+(String) payload.get("addLine1"));
            String addressDetail = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
            addressDetail = addressDetail + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
            addressDetail = addressDetail + "\"district\": \"" + (String) payload.get("district") + "\" ,";
            addressDetail = addressDetail + "\"state\": \"" + (String) payload.get("state") + "\" ,";
            addressDetail = addressDetail + "\"pin\": \"" + (String) payload.get("pin") + "\" }";
            System.out.println("address detail "+addressDetail);
            mentee.setAddressDetail(addressDetail);

            String currentSkills = "{ \"skill1\" : \"" + (String) payload.get("skill1") + "\" ,";
            currentSkills = currentSkills + "\"skill2\" : \"" + (String) payload.get("skill2") + "\" ,";
            currentSkills = currentSkills + "\"skill3\" : \"" + (String) payload.get("skill3") + "\" ,";
            currentSkills = currentSkills + "\"skill4\" : \"" + (String) payload.get("skill4") + "\"} ";
            mentee.setCurrentskills(currentSkills);

             mentee.setEmail((String) payload.get("email"));
            mentee.setPhoneNumber((String) payload.get("phoneNumber"));
            mentee.setGender(((String) payload.get("gender")));
            mentee.setBalance(((Integer) payload.get("balance")));
            mentee.setAge(((Integer) payload.get("age")));
            mentee.setType((String) payload.get("type"));
            System.out.println(mentee);
            menteeRepository.save(mentee);
        System.out.println(mentee.getId());


        return "Mentee Added";
    }
      catch (Exception e)
        {
            System.out.println("aage se NULL aaya");
            e.printStackTrace();
            return e.getMessage();
        }
    }
    public Mentee updateMentee(Mentee mentee)
    {
        Mentee existingMentee = menteeRepository.findByEmail(mentee.getEmail());

        System.out.println("Inside UpdateMentee");
        if(existingMentee!=null)
        {
            existingMentee.setFirstName(mentee.getFirstName());
            existingMentee.setLastName(mentee.getLastName());
            existingMentee.setAddressDetail((mentee.getAddressDetail()));
            existingMentee.setCurrentskills(mentee.getCurrentskills());
            existingMentee.setPhoneNumber(mentee.getEmail());
            existingMentee.setPhoneNumber(mentee.getPhoneNumber());
            existingMentee.setGender(mentee.getGender());
            existingMentee.setBalance(mentee.getBalance());
            existingMentee.setAge(mentee.getAge());
            existingMentee.setType(mentee.getType());
            return  menteeRepository.save(existingMentee);
        }
        else {
            return menteeRepository.save(existingMentee);
        }
    }

    public Mentee updateMentee1(Map<String,Object> payload,Long id)
    {
        System.out.println("in Update service");
        Mentee mentee =  this.menteeRepository.findById(id).get();
        mentee.setFirstName((String) payload.get("firstName"));
        mentee.setLastName((String) payload.get("lastName"));
        String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
        address = address + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
        address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
        address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
        address = address + "\"pin\": \"" + (String) payload.get("pin") + "\" }";

        String addressDetail = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
        addressDetail = addressDetail + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
        addressDetail = addressDetail + "\"district\": \"" + (String) payload.get("district") + "\" ,";
        addressDetail = addressDetail + "\"state\": \"" + (String) payload.get("state") + "\" ,";
        addressDetail = addressDetail + "\"pin\": \"" + (String) payload.get("pin") + "\" }";
        mentee.setAddressDetail(addressDetail);

        String currentSkills = "{ \"skill1\" : \"" + (String) payload.get("skill1") + "\" ,";
        currentSkills = currentSkills + "\"skill2\" : \"" + (String) payload.get("skill2") + "\" ,";
        currentSkills = currentSkills + "\"skill3\" : \"" + (String) payload.get("skill3") + "\" ,";
        currentSkills = currentSkills + "\"skill4\" : \"" + (String) payload.get("skill4") + "\"} ";

        mentee.setEmail((String) payload.get("email"));
        mentee.setPhoneNumber((String) payload.get("phoneNumber"));
        mentee.setGender(((String) payload.get("gender")));
        mentee.setBalance(((Integer) payload.get("balance")));
        mentee.setAge(((Integer) payload.get("age")));
        mentee.setType((String) payload.get("type"));
        menteeRepository.save(mentee);

        return mentee;


    }
    public List<Mentee> getMentees()
    {
        return menteeRepository.findAll();
    }

    public List<Mentee> getAllMentees(){
        List<Mentee> mentees = new ArrayList<Mentee>();
        menteeRepository.findAll().forEach(mentee ->mentees.add(mentee));
        return mentees;
    }


    public Mentee getMenteeById(Long id)
    {
        return menteeRepository.findById(id).get();
    }
        public Mentee getMenteeById1(Map<String,Object> payload,Long id)
    {
        Mentee mentee = this.menteeRepository.findById(id).get();
        return mentee;
    }

   /* public Optional<Mentee> getMenteeByUsername(String username)
    {
        return menteeRepository.findMenteesByUsername(username);
    }*/
    public String deleteMentee(Long id)
    {
       menteeRepository.deleteById(id);
        return "Mentee deleted "+id;
    }
    public String deleteMentee1(Map<String,Object> payload,Long id)
    {
        Mentee mentee =  this.menteeRepository.findById(id).get();
         menteeRepository.deleteById(mentee.getId());
        return "Mentee deleted "+mentee.getId();
    }


    public List<Mentor> getAllMentors(Long id)
    {
        Mentee mentee = menteeRepository.findById(id).get();
         List<Mentor> mentorListOfMentee = mentee.getMentors();
         List<Mentor> listOfAllMentors = mentorEntityService.getMentors();

         List<Mentor> remainingMentors= new ArrayList<>();
         for(int i=0; i<listOfAllMentors.size(); i++){
             Mentor mentor= listOfAllMentors.get(i);
             Long mentorId= mentor.getId();
             for(int j=0; j<mentorListOfMentee.size(); j++){
                 if(mentorId == mentorListOfMentee.get(j).getId())
                     remainingMentors.add(mentor);
             }
         }

         return remainingMentors;
        //return mentorRepository.findAll();
    }
    public List<Mentor> getAllMentors1(Map<String,Object> payload)
    {
        Mentee mentee = this.menteeRepository.findByEmail((String) payload.get("email"));
        // Mentee mentee = menteeRepository.findById(id).get();
        List<Mentor> mentorListOfMentee = mentee.getMentors();
        List<Mentor> listOfAllMentors = mentorEntityService.getMentors();

        List<Mentor> remainingMentors= new ArrayList<>();
        for(int i=0; i<listOfAllMentors.size(); i++){
            Mentor mentor= listOfAllMentors.get(i);
            Long mentorId= mentor.getId();
            for(int j=0; j<mentorListOfMentee.size(); j++){
                if(mentorId == mentorListOfMentee.get(j).getId())
                    remainingMentors.add(mentor);
            }
        }

        return remainingMentors;
        //return mentorRepository.findAll();
    }
//    public Mentor addMentor(Long menteeid,Long mentorid)
//    {
//        Mentee mentee = menteeRepository.getById(menteeid);
//        Mentor mentor = mentorRepository.getById(mentorid);
//        List<Mentor> mentorList = mentee.getMentors();
//        List<Mentee> menteeList = mentor.getMentees();
//        menteeList.add(mentee);
//        mentorList.add(mentor);
//        return mentorRepository.save(mentor);
//    }
//    public Mentee deleteMentor(Long menteeid,Long mentorid)
//    {
//        Mentee mentee = menteeRepository.getById(menteeid);
//        Mentor mentor = mentorRepository.getById(mentorid);
//        List<Mentor> mentorList = mentee.getMentors();
//        mentorList.remove(mentor);
//        return menteeRepository.save(mentee);
//    }

}
