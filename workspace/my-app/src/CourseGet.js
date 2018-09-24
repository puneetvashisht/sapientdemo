import React, { Component } from 'react';
class CourseGet extends Component {


    constructor(){
        super();
        this.input = React.createRef();
        this.state = {course: {name:'', summary: ''}}
    }

    getCourse(){
        console.log('A name was submitted: ' + this.input.current.value);

        fetch('http://localhost:8080/SpringWebDemo/mvc/api/courses/' + this.input.current.value, {
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            }
        })
        .then(res => res.json())
        .then(data=> {
            this.setState({course: data});
        });
    }

    render() {
        return (
            <div>
                <h2>Get A Course</h2>

                <h3>Course Detail: {this.state.course.name} | {this.state.course.summary}</h3>

                <div className="form-group">
                    <label htmlFor="exampleInputEmail1">Course Id</label>
                    <input type="number"  ref={this.input} className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Course Id" />
                </div>
                <div>
                    <button type="button" className="btn btn-primary" onClick={this.getCourse.bind(this)}>Get A Course</button>
                </div>

            </div>
        );
    }
}

export default CourseGet;