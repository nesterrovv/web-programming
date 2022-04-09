# Web-programming course at the ITMO University, 2nd year of study

## Lab work #1 - variant 34100

### Task:
Develop a PHP script that expects to receive points [on a coordinate boundary in a given area](https://github.com/nesterrovv/web-programming/blob/master/media/task1.png), 
and create an HTML page that generates data to send to the script for processing. The R parameter and point coordinates must be passed to the script via an HTTP request. 
The script must perform data validation and return an HTML page with the detection of parameters and calculation results - the fact of detection or missing points 
in the area. Previous results must be processed between queries and in the table. In addition, the response should provide data about the time and the time the script ran.

### The developed HTML page must meet the following requirements:
* For the arrangement of text and graphic elements, it is necessary to use a tabular layout.
* The form data must be submitted for processing via a POST request.
* Style sheets must reside in the web document itself.
* When working with CSS, the use of class selectors, id selectors, element selectors, child selectors, and CSS styling properties such as inheritance and cascading must be demonstrated.
* The HTML page should have a "header" containing the student's full name, group number, and new option. When designing a header, you must explicitly set the font (fantasy), its color and size in the cascading style sheet.
* Input element padding must be specified in pixels.
* The page must contain a JavaScript script that validates the values ​​entered by the user in the form fields. Any invalid values ​​(such as letters in point coordinates or a negative radius) should be blocked.

### Execution: 

You can check the operability of the laboratory work on the university cluster [at this link](https://se.ifmo.ru/~s312621/lab1/page.html). There is a PDF-report in lab work folder.

## Lab work #2 - variant 34101

### Task:
Develop a web application based on servlets and JSP, which determines whether a point [on a coordinate boundary in a given area](https://github.com/nesterrovv/web-programming/blob/master/media/task2.png).

The application must be implemented according to the [MVC pattern](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) and consist of the following elements:

* **ControllerServlet**, which determines the type of request, and, depending on whether the request contains information about the coordinates of the point and the radius, delegating its processing to one of the components listed below. All requests within the application must be sent to this servlet (via the GET or POST method, depending on the job option), other servlets from web pages should not be directly called.
* **AreaCheckServlet**, which checks if a point falls into an area on the coordinate plane and generates an HTML page with the results of the check. Must process all requests containing information about the coordinates of the point and the radius of the area.
* **The JSP page** that renders the HTML page with the web form. Should process all requests that do not contain information about the coordinates of the point and the radius of the area.

**The developed JSP page should contain:**

1. "Header" containing the student's full name, group number and option number.

2. A form that submits data to the server.

3. A set of fields for specifying the coordinates of a point and the radius of an area in accordance with the task option.

4. A JavaScript script that validates the values entered by the user in form fields.

5. An interactive element that contains an image of an area on the coordinate plane (according to the task option) and implements the following functionality:

    * If the area radius is set, the mouse click on the image should be handled by a JavaScript function that determines the coordinates of the point that the user clicked on and sends the resulting coordinates to the server to check for a hit.
    * Otherwise, after clicking on the image, a message should be displayed about the impossibility of determining the coordinates of the point.
    * After checking whether the point is in the area, the image must be updated with the results of this check (i.e., a new point must appear on it).

6. Table with the results of previous checks. The result list must be taken from the application context, HTTP session, or bean, as appropriate.

**The page returned by AreaCheckServlet must contain:**

1. A table containing the received parameters.

2. The result of the calculations is the fact that the point hits or misses the area.

3. A link to a page with a web form for generating a new request.

The developed web application must be deployed on the [WildFly](https://wildfly.org/) server. The server must be running in a standalone configuration, ports must be configured in accordance with the given portbase, access to the http listener must be open to all IPs.
