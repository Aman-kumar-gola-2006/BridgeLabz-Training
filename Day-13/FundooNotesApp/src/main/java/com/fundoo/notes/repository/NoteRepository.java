package com.fundoo.notes.repository;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.Note.NoteState;
import com.fundoo.notes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>, JpaSpecificationExecutor<Note> {

    List<Note> findByUserOrderByCreatedAtDesc(User user);

    List<Note> findByUserIdOrderByCreatedAtDesc(Long userId);

    List<Note> findByUserAndState(User user, NoteState state);

    List<Note> findByUserAndPinnedTrueAndStateNot(User user, NoteState excludedState);

    List<Note> findByUserAndTagsName(User user, String tagName);

    Optional<Note> findByIdAndUser(Long id, User user);

    void deleteByIdAndUser(Long id, User user);
}

