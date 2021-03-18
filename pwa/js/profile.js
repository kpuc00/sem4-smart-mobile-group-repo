let data = [];
$.ajax({
    type: 'GET',
    url: 'data/users.json',
    data: data,
    dataType: 'json',
    success: function (data) {
        console.log(data);
        let user = data[86];
        console.log(user);
        $('#userdata').append("<img src='" + user.avatar + "' alt='User photo' width='30%'>" +
            "<h3><span class='badge badge-warning'>Junior Marketer</span>" + user.fullname + "</h3>" +
            "<p><b>Gender: </b>" + user.gender + "</span><br>" +
            "<b>Language: </b><span>" + user.language + "</span><br>" +
            "<b>E-mail: </b><span>" + user.email + "</span><br>" +
            "<b>Credits: </b><span>" + user.credits + "</span><br>"
        );
    }
})

$.ajax({
    type: 'GET',
    url: 'data/jobs.json',
    data: data,
    dataType: 'json',
    success: function (data) {
        console.log(data);
        let job = data[29];
        console.log(job);
        $('#currentjobs').append("<div class='card' style='width: 18rem; margin: auto;'>" +
            "<div class='card-header'>" +
            "<h5 class='card-title'>" + job.company + "</h5>" +
            "</div>" +
            "<div class='card-body'>" +
            "<p class='card-text'><b>Description: </b>" + job.description + "</p>" +
            "<p class='card-text'><b>Salary: </b>" + job.salary + "</p>" +
            "</div>" +
            "<div class='card-footer'><a href='#' class='btn btn-primary'>See more</a></div>" +
            "</div>"
        );
    }
})

$.ajax({
    type: 'GET',
    url: 'data/jobs.json',
    data: data,
    dataType: 'json',
    success: function (data) {
        let jobs = data.slice(82, 88);
        $.each(jobs, function (index, job) {
            const card = "<div class='mb-3'>" +
                "<div class='card' style='width: 18rem; margin: auto;'>" +
                "<div class='card-header'>" +
                "<h5 class='card-title'>" + job.company + "</h5>" +
                "</div>" +
                "<div class='card-body'>" +
                "<p class='card-text'><b>Description: </b>" + job.description + "</p>" +
                "<p class='card-text'><b>Salary: </b>" + job.salary + "</p>" +
                "</div>" +
                "<div class='card-footer'><a href='#' class='btn btn-primary'>See more</a></div>" +
                "</div></div>";
            switch (index % 3) {
                case 0:
                    $("#col-1").append(
                        card
                    )
                    break;
                case 1:
                    $("#col-2").append(
                        card
                    )
                    break;
                case 2:
                    $("#col-3").append(
                        card
                    )
                    break;
            }
        });
    }
})