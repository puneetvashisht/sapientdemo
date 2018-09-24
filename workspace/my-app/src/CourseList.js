import React, { Component } from 'react';
class CourseList extends Component {

    constructor(){
        super();
        this.state = {courses: []}
    }

    componentDidMount() {
        fetch('http://localhost:8080/SpringWebDemo/mvc/api/courses')
        .then(res => res.json())
        .then(data=> {
            this.setState({courses: data});
        });
    }

    deleteCourse(courseid){
        fetch('http://localhost:8080/SpringWebDemo/mvc/api/courses/'+ courseid, {
            method: 'delete'
          })
        .then(res => {
            console.log(res.status);
        })
    }

    render() {
        console.log('In render', this.state.courses);

        var coursesList = this.state.courses.map((course, index)=>{
            console.log(course);
            return <li class="list-group-item" key={index}><p>{course.name}<button type="button" class="btn btn-danger" onClick={this.deleteCourse(course.id)}>Delete</button></p></li>
        })
        return (
            <ul class="list-group">
                {coursesList}
            </ul>
        );
    }
}

export default CourseList;