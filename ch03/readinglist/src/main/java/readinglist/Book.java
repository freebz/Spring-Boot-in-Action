// 코드 3-8 독자를 나타내는 타입을 Reader로 변경한 Book 엔티티

package readinglist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Reader reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id=id;
    }

    public Reader getReader() {
	return reader;
    }

    public void setReader(Reader reader) {
	this.reader=reader;
    }

    public String getIsbn() {
	return isbn;
    }

    public void setIsbn(String isbn) {
	this.isbn = isbn;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getAuthor() {
	return author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
