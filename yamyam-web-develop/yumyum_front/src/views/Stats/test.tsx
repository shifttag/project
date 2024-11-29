import React, { Component } from 'react';
import FullCalendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid';

class MyCalendar extends Component {
    render() {
        return (
            <div className="App">
                <FullCalendar
                    initialView="dayGridMonth"
                    plugins={[dayGridPlugin]}
                    events={[
                        { title: '이벤트 1', date: '2024-11-01' },
                        { title: '이벤트 2', date: '2024-11-07' },
                        { title: '이벤트 3', date: '2024-11-14' },
                        { title: '이벤트 4', date: '2024-11-21' },
                    ]}
                />
            </div>
        );
    }
}

export default MyCalendar;
