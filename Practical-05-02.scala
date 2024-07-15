case class Book(title: String, author: String, isbn: String)

object LibraryManager {
  var library: Set[Book] = Set(
    Book("The Catcher in the Rye", "J.D. Salinger", "9780316769488"),
    Book("To Kill a Mockingbird", "Harper Lee", "0060935464"),
    Book("1984", "George Orwell", "9780451524935")
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Added book: ${book.title} by ${book.author}")
  }

  def removeBook(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"Removed book: ${book.title} by ${book.author}")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def containsBook(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book => println(s"${book.title} by ${book.author} - ISBN: ${book.isbn}"))
  }

  def searchByTitle(title: String): Unit = {
    library.find(_.title == title) match {
      case Some(book) =>
        println(s"Book found: ${book.title} by ${book.author} - ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with title: $title")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author == author)
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"${book.title} - ISBN: ${book.isbn}"))
    } else {
      println(s"No books found by author: $author")
    }
  }

  def main(args: Array[String]): Unit = {
    val newBook = Book("Pride and Prejudice", "Jane Austen", "9780141439518")
    addBook(newBook)

    removeBook("0060935464")

    val isbnToCheck = "9780451524935"
    println(s"Book with ISBN $isbnToCheck exists: ${containsBook(isbnToCheck)}")

    displayLibrary()

    val titleToSearch = "1984"
    searchByTitle(titleToSearch)

    val authorToSearch = "J.D. Salinger"
    displayBooksByAuthor(authorToSearch)
  }
}