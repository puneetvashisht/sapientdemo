import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import CourseList from './CourseList';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <CourseList></CourseList>
      </div>
    );
  }
}

export default App;
