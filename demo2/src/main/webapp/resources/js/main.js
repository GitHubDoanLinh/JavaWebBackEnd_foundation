$().ready(function () {
    $("#createForm").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            employeeName: {
                required: true,
            },
            salary: {
                required: true,
            },
            birthDate: {
                required: true,
            },
            departmentId: {
                required: true,
            },
        },
        messages: {
            employeeName: {
                required: "Employee Name is require",
            },
            salary: {
                required: "Salary is require",
            },
            birthDate: {
                required: "Birth Date is required",
            },
            birtdepartmentIdhDate: {
                required: "Birth Date is required",
            },
        },
    });
});

$().ready(function () {
    $("#updateForm").validate({
        onfocusout: false,
        onkeyup: false,
        onclick: false,
        rules: {
            employeeName: {
                required: true,
            },
            salary: {
                required: true,
            },
            birthDate: {
                required: true,
            },
            departmentId: {
                required: true,
            },
        },
        messages: {
            employeeName: {
                required: "Employee Name is require",
            },
            salary: {
                required: "Salary is require",
            },
            birthDate: {
                required: "Birth Date is required",
            },
            birtdepartmentIdhDate: {
                required: "Birth Date is required",
            },
        },
    });
});

