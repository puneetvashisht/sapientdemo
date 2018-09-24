import React, { Component } from 'react';

class CourseAdd extends Component {

    constructor(){
        super();
        this.state = {message: ''};
    }


    addCourse(){
        fetch('http://localhost:8080/SpringWebDemo/mvc/api/courses', {
            method: 'POST',
            body: JSON.stringify({name:"Angular", summary:"Test Summary"}),
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
        }).then(res=> {
            console.log(res.status)
            if(res.status == 201){
                this.setState({message: 'Successfully created!!'})
                console.log('Successfully created!!')
            }
            else if(res.status == 409){
                this.setState({message: 'Course Already Exists!!'})
            }
        })

    }

    render() {
        return (

            <div>
                <h2>Add Course</h2>

                <div className="alert alert-success" role="alert">
                        {this.state.message}
                </div>
                <div className="form-group">
                    <label htmlFor="exampleInputEmail1">Name</label>
                    <input type="text" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Course Name"/>
                </div>
                <div className="form-group">
                        <label htmlFor="exampleInputPassword1">Summary</label>
                        <input type="text" className="form-control" id="exampleInputPassword1" placeholder="Enter Course Summary"/>
                </div>
                <div> 
                <button type="button" className="btn btn-primary" onClick={this.addCourse.bind(this)}>Add Course</button>
                </div>       
            </div>

                        );
                    }
                }
                
export default CourseAdd;