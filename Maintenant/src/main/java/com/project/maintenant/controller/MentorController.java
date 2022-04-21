package com.project.maintenant.controller;


import com.project.maintenant.model.entities.Mentee;
import com.project.maintenant.model.entities.Mentor;
import com.project.maintenant.services.MentorEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
public class MentorController
{

    @Autowired
    private MentorEntityService mentorEntityService;

//    @PostMapping("/registermentor")
//    @CrossOrigin(origins="*")
//    public Mentor registerMentor(@RequestBody Mentor mentor) throws Exception
//    {
//
//        String tempEmailId = mentor.getEmail();
//
//        if(tempEmailId!=null && !"".equals(tempEmailId))
//        {
//            Mentor mentorobj = mentorEntityService.fetchMentorByEmailId(tempEmailId);
//            if(mentorobj!=null)
//            {
//                throw new Exception("mentor with "+tempEmailId+" already present");
//            }
//        }
//
//        Mentor mentorobj=null;
//        mentorobj = mentorEntityService.saveMentor(mentor);
//        return mentorobj;
//    }

    @PostMapping("/registermentor")
    public ResponseEntity<?> addMentor(@RequestBody Map<String, Object> payload) throws Exception{
        System.out.println("in register mentor api: REGISTER");
        String res = mentorEntityService.addMentor(payload);
        return  ResponseEntity.ok(res);
    }

//    @PostMapping("/mentorlogin")
//    @CrossOrigin(origins="*")
//
//    public Mentor loginMentor(@RequestBody Mentor mentor) throws Exception
//    {
//        String tempEmailId=mentor.getEmail();
//        String tempPass=mentor.getPassword();
//        Mentor mentorobj=null;
//        if(tempEmailId!=null && tempPass!=null)
//        {
//            mentorobj =  mentorEntityService.fetchMentorByEmailIdAndPassword(tempEmailId,tempPass);
//        }
//        if(mentorobj==null)
//        {
//            throw new Exception("incorrect credentials");
//        }
//        return mentorobj;
//    }
@PostMapping("/mentor/login")
public ResponseEntity<?> login(@RequestBody Map<String,Object> payload){
    if (mentorEntityService.login(payload)){
        return ResponseEntity.ok("mentor logged in Successfully");
    }
    else
        return ResponseEntity.badRequest().body("Invalid Username or Password!");
}

//    @GetMapping("/allmentor")
//    @CrossOrigin(origins="*")
//    public List<Mentor> findAllMentor()
//    {
//        return mentorEntityService.getMentors();
//    }
@RequestMapping("/getallmentors")
public ResponseEntity<?> getAllMentors(){

    System.out.println("In get all mentors api");
    List<Mentor> mentors = mentorEntityService.getAllMentors();
    return ResponseEntity.ok(mentors);
}

//    @GetMapping("/allmentor/{id}")
//    @CrossOrigin(origins="*")
//    public  Mentor findMentorById(@PathVariable Long id)
//    {
//        return mentorEntityService.getMentorById(id);
//    }
@RequestMapping(value="/allmentor/{id}")
public ResponseEntity<?> findMentorById(@RequestBody Map<String,Object> payload,@PathVariable Long id){
    System.out.println("in get mentor with id api");
    Mentor mentor = mentorEntityService.getMentorById1(payload,id);
    return ResponseEntity.ok(mentor);
}
//    @PutMapping("/mentorupdate")
//    @CrossOrigin(origins="*")
//    public Mentor updateMentor(@RequestBody Mentor mentor)
//    {
//        return mentorEntityService.updateMentor(mentor);
//    }
@RequestMapping(value="/updatementor/{id}", method = RequestMethod.PUT)
public ResponseEntity<?> updateMentor(@RequestBody Map<String,Object> payload, @PathVariable Long id) throws Exception{
    System.out.println("in update mentor api");
    Mentor mentor = mentorEntityService.updateMentor1(payload,id);
    return  ResponseEntity.ok(mentor);
}
//    @DeleteMapping("/mentordelete/{id}")
//    @CrossOrigin(origins="*")
//    public String deleteMentor(@PathVariable Long id)
//    {
//        return mentorEntityService.deleteMentor(id);
//    }
@RequestMapping(value="/deletementor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMentor(@RequestBody Map<String,Object> payload, @PathVariable Long id) throws Exception{
        System.out.println("in delete mentor api");
        String res = mentorEntityService.deleteMentor1(payload,id);
        return  ResponseEntity.ok(res);
    }
//    @PutMapping("/addmentor/{mentorid}/{menteeid}")
//    @CrossOrigin(origins="*")
//    public Mentor addMentor(@PathVariable Long menteeid,
//                            @PathVariable Long mentorid)
//    {
//        return mentorEntityService.addMentor(menteeid,mentorid);
//    }
@RequestMapping(value="/addmentor/{mentorid}/{menteeid}", method = RequestMethod.PUT)
public ResponseEntity<?> addmentors(@RequestBody Map<String,Object> payload, @PathVariable Long mentorid,@PathVariable Long menteeid) throws Exception {
    Mentor mentor =  mentorEntityService.addMentor1(payload,menteeid,mentorid);
    return ResponseEntity.ok(mentor);
}
//    @GetMapping("/mentor/{id}")
//    public  List<Mentee> findAllMentees(@PathVariable Long id)
//    {
//        return mentorEntityService.getAllMentees(id);
//    }
//    @GetMapping("/mymentees/{mentorid}")
//    @CrossOrigin(origins="*")
//    public List<Mentee> mymentees(@PathVariable Long mentorid)
//    {
//
//        List<Mentee> mymentees = mentorEntityService.getAllMentees(mentorid);
//        return mymentees;
//
//    }
@RequestMapping(value="/mymentees/{mentorid}")
public ResponseEntity<?> mymentees(@RequestBody Map<String,Object> payload,@PathVariable Long mentorid){
    System.out.println("in get list of mentees of that mentor api");
    List<Mentee> mymenteess = mentorEntityService.getAllMentees1(payload,mentorid);
     return ResponseEntity.ok(mymenteess);

}
//    @PutMapping("/deletementor/{mentorid}/{menteeid}")
//    @CrossOrigin(origins="*")
//    public Mentor deleteMentor(@PathVariable Long menteeid,
//                            @PathVariable Long mentorid)
//    {
//        return mentorEntityService.deleteMentorwmap(menteeid,mentorid);
//    }
@RequestMapping(value="/deletementor/{mentorid}/{menteeid}", method = RequestMethod.PUT)
public ResponseEntity<?> deleteentors(@RequestBody Map<String,Object> payload, @PathVariable Long mentorid,@PathVariable Long menteeid) throws Exception {
    Mentor mentor = mentorEntityService.deleteMentorwmap1(payload, mentorid, menteeid);
    return ResponseEntity.ok(mentor);
}
}
