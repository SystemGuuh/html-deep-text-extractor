# HTML Deep Text Extractor

## Objective 
Retrieve the text snippet contained at the deepest level of the HTML structure from a given URL.

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

## Execution instructions
- Compile the file using: 'javac HtmlAnalyzer.java'
- Run with 'java HtmlAnalyzer insert-url-here'

If you want to check the project in its current state:
- [https://github.com/SystemGuuh/html-deep-text-extractor](https://github.com/SystemGuuh/html-deep-text-extractor)

## About the complexity of the program:
- Best-case complexity: O(n/2)
- Worst-case complexity: O(n)

## About the functions:
- Conn: function to connect and return the HTML of a page
- DeepText: function to search for the deepest text
- HtmlAnalyzer: main structure of the code
- htmlTag: encapsulation of tags
- Validation: validation of the HTML structure

## Thrown errors:
- Malformed: if the structure has unclosed opening tags or vice versa
- Connection error: no internet

## Possible improvements or next steps:
- Throw errors for invalid inputs, incorrect HTML, or input/output errors
- Handle HTML structures without a deepest text
- It might be possible to improve the worst-case complexity with a hashmap
- Create a dynamic array for each tag and its content
- Regex for self-closing tags

