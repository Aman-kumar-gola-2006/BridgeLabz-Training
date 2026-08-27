package com.fundoo.notes.specification;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.Note.NoteState;
import com.fundoo.notes.entity.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class NoteSpecifications {

    public static Specification<Note> search(User owner, String titleText, NoteState state, String tagName) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // ALWAYS required for authorization scope
            if (owner != null) {
                predicates.add(criteriaBuilder.equal(root.get("user"), owner));
            }

            if (titleText != null && !titleText.isBlank()) {
                Predicate titleLike = criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("title")),
                        "%" + titleText.toLowerCase() + "%"
                );
                Predicate descLike = criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("description")),
                        "%" + titleText.toLowerCase() + "%"
                );
                predicates.add(criteriaBuilder.or(titleLike, descLike));
            }

            if (state != null) {
                predicates.add(criteriaBuilder.equal(root.get("state"), state));
            }

            if (tagName != null && !tagName.isBlank()) {
                predicates.add(criteriaBuilder.equal(root.join("tags").get("name"), tagName));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
