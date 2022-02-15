# Web-programming course at the ITMO University, 2th year of study

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

