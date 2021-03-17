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
        $('#currentjobs').append("<div class='card' style='width: 18rem;'><div class='card-body'>" +
            "<h5 class='card-title'>" + job.company + "</h5>" +
            "<p class='card-text'>" + job.description + "</p>" +
            "<a href='#' class='btn btn-primary'>See more</a></div></div>"
        );
    }
})