# HTML Deep Text Extractor

Objective: Retrieve the text snippet contained at the deepest level of the HTML structure from a given URL.

For example:

http://hiring.axreng.com/internship/example1.html

```html
<html>
	<head>
		<title>
			This is the title.
		</title>
	</head>
<body>
	This is the body.
</body>
</html>
```

In the above HTML structure, the desired snippet to be returned is "This is the title." (without quotes) because it is at a depth of 3 (html > head > title), while the snippet "This is the body." is at a depth of 2 (html > body).  
If two or more snippets are at the maximum depth of the document, the first one encountered should be returned. To simplify the problem scope, the solution should be based on the following assumptions:
 - HTML code is divided into lines.
- Each line can only contain one of the following types:  
- Opening tag (example: ```<div>```)  
- Closing tag (example: ```</div>```)
- Text snippet (example: "This is the body.")  
- A single line cannot contain two different types of content.
- Only HTML elements with matching opening and closing tags are used (example: ```<div>``` and ```</div>```, but not ```<br/>```).
- Opening tags do not have attributes (counter-example: ```<a href="link.html">```). 
- Each line may or may not have leading spaces, used for indentation, which should be ignored. Blank lines should also be ignored.

Execution instructions:
- Compile the file using: 'javac HtmlAnalyzer.java'
- Run with 'java HtmlAnalyzer insert-url-here'

If you want to check the project in its current state:
- https://github.com/SystemGuuh/html-deep-text-extractor

About the complexity of the program:
- Best-case complexity: O(n/2)
- Worst-case complexity: O(n)

About the functions:
- Conn: function to connect and return the HTML of a page
- DeepText: function to search for the deepest text
- HtmlAnalyzer: main structure of the code
- htmlTag: encapsulation of tags
- Validation: validation of the HTML structure

Thrown errors:
- Malformed: if the structure has unclosed opening tags or vice versa
- Connection error: no internet

Possible improvements or next steps:
- Throw errors for invalid inputs, incorrect HTML, or input/output errors
- Handle HTML structures without a deepest text
- It might be possible to improve the worst-case complexity with a hashmap
- Create a dynamic array for each tag and its content
- Regex for self-closing tags
