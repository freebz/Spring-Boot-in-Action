// 코드 5-2 ReadingListRepository 인터페이스

interface ReadingListRepository {
    List<Book> findByReader(String reader)
    void save(Book book)
}
