import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  
  public user = {
    username: '',
    password: '',
    fname: '',
    lname: '',
    email: '',
    phone: '',
    gender: '',
    age: 0,
    addLine1: '',
    addLine2: '',
    district: '',
    pin: '',
    state:''
  };

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }

  formSubmit() {

    console.log(this.user);
    if (this.user.username == '' || this.user.username == null) {
       alert('User is required !!');
      // this.snack.open('Username is required !! ', '', {
      //   duration: 3000,
      // });
      return;
    }

    // if (this.user.password == '' || this.user.password == null) {
    //   // alert('User is required !!');
    //   this.snack.open('Password is required !! ', '', {
    //     duration: 3000,
    //   });
    //   return;
    // }

    // //validate

    //addUser: userservice
    this.userService.addUser(this.user).subscribe(
      (data: any) => {
        //success
        console.log(data);
        //alert('success');
        //Swal.fire('Successfully done !!', 'User id is ' + data.id, 'success');
      },
      (error) => {
        //error
        console.log(error);
        // alert('something went wrong');
        // this.snack.open(error.error.text, '', {
        //   duration: 3000,
        // });
      }
    );
  }

}
