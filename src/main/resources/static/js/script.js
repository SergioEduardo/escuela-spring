const std = document.getElementById('studentsSelect') || null;
const sbj = document.getElementById('subjectsSelect') || null;
const grd = document.getElementById('gradeInput') || null;
let studentNameSelected = '';

std.addEventListener('change', () => {
    console.log(std.options[std.selectedIndex].text);
    studentNameSelected = std.options[std.selectedIndex].text;
});


async function fetchData(url = '', method, data) {
    const response = await fetch(url, {
        method: method,
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin',
        headers: {
            'Content-Type': 'application/json'
        },
        redirect: 'follow',
        referrerPolicy: 'no-referrer',
        body: JSON.stringify(data)
    });
    return response.json();
}


function getCatalogs() {
    const students = fetchData('/students', 'GET');
    const subjects = fetchData("/subjects", 'GET');
    students.then(data => {
        data.forEach(s => {
            const opt = document.createElement("option");
            opt.value = s.studentId;
            opt.text = `${s.name} ${s.lastName} ${s.mLastName}`;
            std.add(opt);
        });
    });
    subjects.then(data => {
        data.forEach(s => {
            const opt = document.createElement("option");
            opt.value = s.subjectId;
            opt.text = s.name;
            sbj.add(opt);
        });

    });
}

document.getElementById('saveButton')
    .addEventListener('click', () => {
        const gradeData = grd.value;
        const studentId = std.value;
        const subjectId = sbj.value;
        if (studentId > 0 && subjectId > 0) {
            if (gradeData >= 0 && gradeData <= 10.0) {
                const grade = {'grade': gradeData, 'studentId': studentId, 'subjectId': subjectId};
                fetchData('/grades/create', 'POST', grade)
                    .then(response => {
                        document.getElementById('alert').style.display = 'block';
                        document.getElementById('showButton').click();
                    });

            } else {
                console.log("El rango de calificación no es valido");
            }
        } else {
            console.log("Selecciona un estudiante y una materia para ingresar una calificación");

        }
    });

document.getElementById('showButton')
    .addEventListener('click', () => {
        const studentId = std.value;
        const grades = fetchData(`/grades/getByStudent/${studentId}`, 'GET');
        grades.then(response => {
            clearTable();
            response.grades.forEach((row, index) => {
                const nRow = document.getElementById('tContainer').insertRow();
                nRow.setAttribute('id', row.gradeId);
                const hCell = document.createElement('th');
                hCell.innerHTML = (index + 1);
                nRow.appendChild(hCell);

                const nCellStudent = nRow.insertCell();
                const nCellSubject = nRow.insertCell();
                const nCellGrade = nRow.insertCell();
                const nCellDate = nRow.insertCell();
                const nCellActions = nRow.insertCell();
                const nodeStudent = document.createTextNode(studentNameSelected.toUpperCase());
                const nodeSubject = document.createTextNode(row.subjectName.toUpperCase());
                const nodeGrade = document.createTextNode(row.grade);
                const nodeDate = document.createTextNode(row.registrationDate);
                const bModification = document.createElement('button');
                const bDelete = document.createElement('button');
                bModification.innerHTML = 'Modificar';
                bModification.setAttribute('id', `M-${row.gradeId}`);
                bModification.setAttribute('class', 'btmModif');
                bModification.setAttribute('onclick', 'openModalM(' + `${row.gradeId}` + ')');
                bDelete.innerHTML = 'Eliminar';
                bDelete.setAttribute('id', `D-${row.gradeId}`);
                bDelete.setAttribute('class', 'btnDelete');
                bDelete.setAttribute('onclick', 'openModalD(' + `${row.gradeId}` + ')');

                nCellStudent.appendChild(nodeStudent);
                nCellSubject.appendChild(nodeSubject);
                nCellGrade.appendChild(nodeGrade);
                nCellDate.appendChild(nodeDate);
                nCellActions.appendChild(bModification);
                nCellActions.appendChild(bDelete);

            });
            document.getElementById('average').textContent = response.average.studentAverage;
        });
    });

document.getElementById('confMod')
    .addEventListener('click', () => {
        const gradeId = document.getElementById('confMod').getAttribute('name');
        const gradeValue = document.getElementById('gradeMod').value;
        if (gradeValue >= 0 && gradeValue <= 10.0) {
            const grade = {'gradeId': gradeId, 'grade': gradeValue};
            fetchData('/grades/update', 'PUT', grade).then(response => {
                closeModal('modal-m');
                document.getElementById('showButton').click();
            });
        } else {
            console.log("El rango de calificación no es valido");
        }
    });

document.getElementById('confDel')
    .addEventListener('click', () => {
        const gradeId = document.getElementById('confDel').getAttribute('name');
        const grade = {'gradeId': gradeId};
        fetchData('/grades/remove', 'DELETE', grade).then(response => {
            closeModal('modal-d');
            document.getElementById('showButton').click();
        });
    })

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
}

function openModalM(rowId) {
    const dataRow = document.getElementById(rowId).cells;
    const subject = dataRow[2].textContent;
    const currentGrade = dataRow[3].textContent;
    document.getElementById('studentMod').textContent = studentNameSelected;
    document.getElementById('subjectMod').textContent = subject;
    document.getElementById('gradeMod').setAttribute('value', currentGrade);
    document.getElementById('confMod').setAttribute('name', rowId);
    document.getElementById('modal-m').style.display = 'block';
}

function openModalD(rowId) {
    const dataRow = document.getElementById(rowId).cells;
    const subject = dataRow[2].textContent;
    const currentGrade = dataRow[3].textContent;
    document.getElementById('studentDel').textContent = studentNameSelected;
    document.getElementById('subjectDel').textContent = subject;
    document.getElementById('gradeDel').textContent = currentGrade;
    document.getElementById('confDel').setAttribute('name', rowId);
    document.getElementById('modal-d').style.display = 'block';
}

function clearTable() {
    const oldTable = document.getElementById('tContainer');
    const cleanTable = document.createElement('tbody');
    oldTable.parentNode.replaceChild(cleanTable, oldTable);
    cleanTable.setAttribute('id', 'tContainer');
}