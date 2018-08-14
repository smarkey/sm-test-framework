1. 4 hours if I include the initial framework plumbing.
* Remove reliance on css selectors which make tests brittle
* Pay more attention to asynchronous loaded elements on page (again, brittleness)
* Add wrapper to unpacking of elements, which will handle StaleElementExceptions (scalatest-specific)
* Use the tech stack in use at Just Eat currently :)
2. The emergence of AI as a technology to bridge the gap between automation and what a manual tester can do in terms of exploratory testing.
3. I would require more detail about the nature of the legacy system but:
* If it had a browser accesible UI, selenium would still be a viable option. (I have tested the UI of very old ASP MVC projects)
* If it was a slightly outdated API that utilised SOAP/XML rather than REST/json the same api testing principles apply to both - http requests except the payload would be in xml rather than json. (I have teste SOAP API's)
* If it was component/integration tests in a legacy language, it would require me to learn the language.
4. I did notice that the test restaurant "Load Test AR605CE38209C4C248C2A35F59E0345A279B" highlights that restaurant names overflow into the delivery pane. This could be improved by clipping the text and adding ellipses and the "title" attribute will then display the whole name when the customer hovers over the restaurant name.
5.
{
	"name": {
		"fName": "Steven",
		"lName": "Markey
	},
	"dob": "20/09/85",
	"nationality": "Irish",
	"location": "Bristol",
	"languages": ["English", "Gaelic", "Java", "C#", "Python", "Scala", "Groovy", "VB6"]
	"hobbies": ["food", "music", "football", "movies", "travel"]
}