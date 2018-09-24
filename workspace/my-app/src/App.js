import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import CourseList from './CourseList';
import CourseAdd from './CourseAdd';
import CourseGet from './CourseGet';

class App extends Component {
  render() {
    return (
      <div className="App">

       <CourseGet></CourseGet>

        <hr/>

        <CourseAdd></CourseAdd>

        <hr/>

        <CourseList></CourseList>

       

       
      </div>
    );
  }
}

export default App;
