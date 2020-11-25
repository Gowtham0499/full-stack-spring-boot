import axios from 'axios';
import React from 'react';
import {Line} from 'react-chartjs-2';

const initdata = {
    labels: [],
    datasets: [{
        label: '',
        data: [],
        fill: false,
        borderWidth: 8
    }]
}

class ChartGenerator extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            chartData: initdata
        }
    }

    componentWillMount() {
        axios.get('http://localhost:8080/clinicalservices/api/patients/' + this.props.match.params.patientId)
            .then(res=>{
                console.log(res.data);
                if(this.props.match.params.componentName === 'heartrate') {
                    var heartRateData = res.data.clinicalData.filter(component=>component.componentName==='heartrate')
                    for(var i=0; i<heartRateData.length; i++) {
                        initdata.labels[i] = heartRateData[i].measuredDateTime;
                        initdata.datasets[0].label = 'HeartRate';
                        initdata.datasets[0].data[i] = heartRateData[i].componentValue;
                    }
                    this.setState({initdata})
                }
            })
    }

    render() {
        return(
            <div>
                <Line data={this.state.chartData} />
            </div>
        )
    }

}

export default ChartGenerator;