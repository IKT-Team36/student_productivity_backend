package mk.ukim.finki.studentproductivityhelperapp.repositoryNote;


import mk.ukim.finki.studentproductivityhelperapp.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
