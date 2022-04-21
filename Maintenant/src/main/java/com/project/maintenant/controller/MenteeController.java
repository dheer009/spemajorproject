package com.project.maintenant.controller;

import com.project.maintenant.model.entities.Mentee;
import com.project.maintenant.model.entities.Mentor;
import com.project.maintenant.services.MenteeEntityService;
import com.project.maintenant.services.MentorEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
//@CrossOrigin(origins = "http://localhost:56629/")
public class MenteeController
{

@Autowired
private MenteeEntityService menteeEntityService;
@Autowired
private MentorEntityService mentorEntityService;

//    @PostMapping("/registermentee")
////    @CrossOrigin(origins="*")
//    public Mentee registerMentee(@RequestBody Map<String, Object> payload) throws Exception
//    {
//
//        String tempEmailId = (String)payload.get("email");
//
//        if(tempEmailId!=null && !"".equals(tempEmailId))
//        {
//            Mentee menteeobj = menteeEntityService.fetchMenteeByEmailId(tempEmailId);
//            if(menteeobj!=null)
//            {
//                throw new Exception("mentee with "+tempEmailId+" already present");
//            }
//        }
//
//        Mentee menteeobj=null;
//        menteeobj = menteeEntityService.addMentee(payload);
//        return menteeobj;
//    }

    @PostMapping("/registermentee")
    public ResponseEntity<?> addMentee(@RequestBody Map<String, Object> payload) throws Exception{
        System.out.println("in register mentee api: REGISTER");
        String res = menteeEntityService.addMentee(payload);
        return  ResponseEntity.ok(res);
    }


//    @PostMapping("/menteelogin")
////    @CrossOrigin(origins="*")
//    public Mentee loginMentee(@RequestBody Map<String, Object> payload) throws Exception
//    {
//        String tempEmailId = (String)payload.get("email");
//        System.out.println(tempEmailId);
//        String tempPass= (String)payload.get("password");
//        System.out.println(tempPass);
//        Mentee menteeobj=null;
//        if(tempEmailId!=null && tempPass!=null)
//        {
//            menteeobj =  menteeEntityService.fetchMenteeByEmailIdAndPassword(tempEmailId,tempPass);
//        }
//        if(menteeobj==null)
//        {
//            throw new Exception("incorrect credentials");
//        }
//        return menteeobj;
//    }

    @PostMapping("/mentee/login")
    public ResponseEntity<?> login(@RequestBody Map<String,Object> payload){
        if (menteeEntityService.login(payload)){
            return ResponseEntity.ok("mentee logged in Successfully");
        }
        else
            return ResponseEntity.badRequest().body("Invalid Username or Password!");
    }

//    @GetMapping("/allmentee")
////    @CrossOrigin(origins="*")
//   public List<Mentee> findAllMentee()
//   {
//       return menteeEntityService.getMentees();
//   }
@RequestMapping("/getallmentees")
public ResponseEntity<?> getAllMentees(){

    System.out.println("In get all mentee api");
    List<Mentee> mentees = menteeEntityService.getAllMentees();
    return ResponseEntity.ok(mentees);
}

//    @GetMapping("/allmentee/{id}")
////    @CrossOrigin(origins="*")
//   public  Mentee findMenteeById(@PathVariable Long id)
//   {
//       return menteeEntityService.getMenteeById(id);
//   }
@RequestMapping(value="/allmentee/{id}")
public ResponseEntity<?> findMenteeById(@RequestBody Map<String,Object> payload,@PathVariable Long id){
    System.out.println("in get mentee with id api");
    Mentee mentee = menteeEntityService.getMenteeById1(payload,id);
    return ResponseEntity.ok(mentee);
}

//   @GetMapping("/allmentees")
////   @CrossOrigin(origins="*")
//   public List<Mentee> getAllMentees()
//   {
//       return menteeEntityService.getMentees();
//   }
//@RequestMapping(value="/allmentees")
//public ResponseEntity<?> allMentees(@PathVariable Long id) {
//    System.out.println("in get complaint api");
//    Mentee mentee = menteeEntityService.getMenteeById(id);
//    return ResponseEntity.ok(mentee);
//}
   //doubt
//   @PutMapping("/menteeupdate")
////   @CrossOrigin(origins="*")
//   public Mentee updateMentee(@RequestBody Mentee mentee)
//   {
//       return menteeEntityService.updateMentee(mentee);
//   }
   @RequestMapping(value="/updatementee/{id}", method = RequestMethod.PUT)
   public ResponseEntity<?> updateMentee(@RequestBody Map<String,Object> payload, @PathVariable Long id) throws Exception{
       System.out.println("in update mentee  api");
       Mentee mentee = menteeEntityService.updateMentee1(payload,id);
       return  ResponseEntity.ok(mentee);
   }

//   @DeleteMapping("/menteedelete/{id}")
////   @CrossOrigin(origins="*")
//   public String deleteMentee(@PathVariable Long id)
//   {
//       return menteeEntityService.deleteMentee(id);
//   }
@RequestMapping(value="/deletementee/{id}", method = RequestMethod.DELETE)
public ResponseEntity<?> deleteMentee(@RequestBody Map<String,Object> payload, @PathVariable Long id) throws Exception{
    System.out.println("in delete mentee api");
    String res = menteeEntityService.deleteMentee1(payload,id);
    return  ResponseEntity.ok(res);
}

//    @GetMapping("/allmentors")
////    @CrossOrigin(origins="*")
//    public List<Mentor> getAllMentors()
//    {
//        return mentorEntityService.getMentors();
//    }
@RequestMapping(value="/allmentors")
public ResponseEntity<?> getAllMentors() {
    System.out.println("in get all mentors inside mentee api");
    List<Mentor> mentorList = mentorEntityService.getAllMentors();
    return ResponseEntity.ok(mentorList);
}
//    @PutMapping("/addmentor/{menteeid}/{mentorid}")
//    public Mentor addMentor(@PathVariable Long menteeid,
//                            @PathVariable Long mentorid)
//    {
//        return menteeEntityService.addMentor(menteeid,mentorid);
//    }
//    @PutMapping("/deletementor/{menteeid}/{mentorid}")
//    public Mentee deleteMentor(@PathVariable Long menteeid,
//                            @PathVariable Long mentorid)
//    {
//        return menteeEntityService.deleteMentor(menteeid,mentorid);
//    }




}
