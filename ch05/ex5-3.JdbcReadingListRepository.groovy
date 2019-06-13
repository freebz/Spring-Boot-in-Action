// 코드 5-3 그루비로 구현한 JDBC ReadingListRepository

@Repository
class JdbcReadingListRepository implements ReadingListRepository {

    @Autowired
    JdbcTemplate jdbc    // JdbcTemplate 주입
    List<Book> findByReader(String reader) {
	jdbc.query(
	    "select id, reader, isbn, title, author, description " +
	    "from Book where reader=?",
	    { rs, row ->
		new Book(id: rs.getLong(1),
		    reader: rs.getString(2),
		    isbn: rs.getString(3),
		    title: rs.getString(4),
		    author: rs.getString(5),
		    description: rs.getString(6))
	    } as RowMapper,    // RowMapper 클로저
	    reader)
    }

    void save(Book book) {
	jdbc.update("insert into Book " +
	    "(reader, isbn, title, author, description) " +
	    "values (?, ?, ?, ?, ?)",
	    book.reader,
	    book.isbn,
	    book.title,
	    book.author,
	    book.description)
    }

}
