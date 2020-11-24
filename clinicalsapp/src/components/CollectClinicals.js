import React from 'react';
import axios from 'axios';
import { toast } from 'react-toastify';

class CollectClinicals extends React.Component {

    state = {}

    componentDidMount() {
        axios.get("http://localhost:8080/clinicalservices/api/patients/" + this.props.match.params.patientId)
            .then(res=>{
                this.setState(res.data);
            })
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = {
            patientId: this.props.match.params.patientId,
            componentName: this.componentName,
            componentValue: this.componentValue
        }
        axios.post("http://localhost:8080/clinicalservices/api/clinicals", data)
            .then(res=>{
                toast("Patient data saved successfully", {autoClose:2000, position: toast.POSITION.BOTTOM_CENTER});
            })
    }

    render() {
        return(
            <div>
                <h2>Patient Details</h2><br/>
                First Name: {this.state.firstName} <br/>
                Last Name: {this.state.lastName} <br/>
                Age: {this.state.age} <br/>

                <h2>Patient's Clinical Data</h2>
                <form>
                    clinical Entry Type: <select onChange={(event)=>{this.componentName = event.target.value}}>
                        <option>Select one</option>
                        <option value="bp">Blood Pressure(Sys/Dys)</option>
                        <option value="hw">Height/Weight</option>
                        <option value="heartRate">Heart Rate</option>
                    </select> <br/><br/>
                    Value: <input type="text" name="componentValue" onChange={(event)=> this.componentValue = event.target.value} /> <br/><br/>
                    <button onClick={this.handleSubmit.bind(this)} >Save</button>
                </form>

            </div>
        )
    }

}

export default CollectClinicals;