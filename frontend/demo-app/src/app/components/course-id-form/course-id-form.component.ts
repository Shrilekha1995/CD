import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-course-id-form',
  templateUrl: './course-id-form.component.html',
  styleUrls: ['./course-id-form.component.css']
})
export class CourseIdFormComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  setCourseId(courseId:any)
  {
    alert(courseId);
    localStorage.setItem("course_id",courseId);
    this.router.navigate(['/courses']);

  }


}
