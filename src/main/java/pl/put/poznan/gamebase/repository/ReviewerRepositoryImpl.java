package pl.put.poznan.gamebase.repository;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import pl.put.poznan.gamebase.structures.Reviewer;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt.AttributeMappingBuilder;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.gamebase.structures.QReviewer;

/**
 * = ReviewerRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = ReviewerRepositoryCustom.class)
@Transactional(readOnly = true)
public class ReviewerRepositoryImpl extends QueryDslRepositorySupportExt<Reviewer> implements ReviewerRepositoryCustom {

    /**
     * Default constructor
     */
    ReviewerRepositoryImpl() {
        super(Reviewer.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String AFFILITY = "affility";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String NICK = "nick";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CRITIC = "critic";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Reviewer> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QReviewer reviewer = QReviewer.reviewer;
        JPQLQuery<Reviewer> query = from(reviewer);
        Path<?>[] paths = new Path<?>[] { reviewer.nick, reviewer.critic, reviewer.affility };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(NICK, reviewer.nick).map(CRITIC, reviewer.critic).map(AFFILITY, reviewer.affility);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, reviewer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Reviewer> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
        QReviewer reviewer = QReviewer.reviewer;
        JPQLQuery<Reviewer> query = from(reviewer);
        Path<?>[] paths = new Path<?>[] { reviewer.nick, reviewer.critic, reviewer.affility };
        applyGlobalSearch(globalSearch, query, paths);
        // Also, filter by the provided ids
        query.where(reviewer.id.in(ids));
        AttributeMappingBuilder mapping = buildMapper().map(NICK, reviewer.nick).map(CRITIC, reviewer.critic).map(AFFILITY, reviewer.affility);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, reviewer);
    }
}
