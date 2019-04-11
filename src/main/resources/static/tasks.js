var RESTAPI = "http://127.0.0.1:4567/api/v1.0";

function load_task_list(father_div) {

    father_div.html("<ul></ul>");
    let ul = father_div.find("ul");

    $.getJSON(RESTAPI + "/tasks", function (data) {
        let tasks = data["tasks"]; // the dictionary from JSON

        for (let index in tasks) {
            if (tasks.hasOwnProperty(index))
                if(tasks[index].urgent === 1)
                    ul.append($("<li>" + tasks[index].description + " - <em>urgente</em></li>"));
                else
                    ul.append($("<li>" + tasks[index].description + "</li>"));

        }
    });
}

$(document).ready(function () {

    load_task_list($("#theList"));

});