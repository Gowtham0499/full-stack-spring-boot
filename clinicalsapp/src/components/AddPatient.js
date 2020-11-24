import axios from 'axios';
import React from 'react';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { Link } from 'react-router-dom';

toast.configure();

class AddPatient extends React.Component {

    handleSubmit(event) {
        event.preventDefault();
        const data = {
            firstName: this.firstName,
            lastName: this.lastName,
            age: this.age
        }
        axios.post("http://localhost:8080/clinicalservices/api/patients", data)
            .then(res=>{
                toast("Patient Added Successfully!", {autoClose:2000, position:toast.POSITION.BOTTOM_CENTER})
            })
    }

    render() {
        return (
            <div>
                <h2>Create Patient</h2>
                <form>
                    First Name: <input type='text' name='firstName' onChange={(event=>this.firstName = event.target.value)} /><br/><br/>
                    Last Name: <input type='text' name='lastName' onChange={(event=>this.lastName = event.target.value)} /><br/><br/>
                    Age: <input type='text' name='age' onChange={(event=>this.age = event.target.value)} /><br/><br/>
                    <button onClick={this.handleSubmit.bind(this)}>Submit</button><br/><br/>
                </form>
                <Link to={'/'}>Go back</Link>
            </div>
        )
    }

}

export default AddPatient;