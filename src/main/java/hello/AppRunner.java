package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("run")
    public String run() throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        return "run 01";
    }

    @GetMapping("run2")
    public String run2() throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        return "run 02";
    }

    @GetMapping("run3")
    public String run3() throws Exception {
        logger.info(".... Fetching books");
        logger.info("isbn-XXXX -->" + bookRepository.getByIsbn("isbn-XXXX"));
        logger.info("isbn-XXXX -->" + bookRepository.getByIsbn("isbn-XXXX"));
        return "run 02";
    }

    @GetMapping("clear")
    public String clear() throws Exception {
        bookRepository.clear();
        return "clear";
    }

}