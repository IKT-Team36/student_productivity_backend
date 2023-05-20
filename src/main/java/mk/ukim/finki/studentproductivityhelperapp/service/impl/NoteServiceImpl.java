package mk.ukim.finki.studentproductivityhelperapp.service.impl;

import mk.ukim.finki.studentproductivityhelperapp.model.Course;
import mk.ukim.finki.studentproductivityhelperapp.model.Note;
import mk.ukim.finki.studentproductivityhelperapp.model.User;
import mk.ukim.finki.studentproductivityhelperapp.model.dto.NoteDto;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.CourseNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.NoteNotFoundException;
import mk.ukim.finki.studentproductivityhelperapp.model.exceptions.UserIdDoesNotExistException;
import mk.ukim.finki.studentproductivityhelperapp.repository.CourseRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.NoteRepository;
import mk.ukim.finki.studentproductivityhelperapp.repository.UserRepository;
import mk.ukim.finki.studentproductivityhelperapp.service.NoteService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public NoteServiceImpl(NoteRepository noteRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Note> findAll() {
        return this.noteRepository.findAll();
    }

    @Override
    public Optional<Note> findById(Long id) {
        return Optional.of(this.noteRepository.getReferenceById(id));
    }

    @Override
    public Optional<Note> save(NoteDto noteDto) {
        User user = this.userRepository.findById(noteDto.getUser())
                .orElseThrow(() -> new UserIdDoesNotExistException(noteDto.getUser()));
        Course course = this.courseRepository.findById(noteDto.getCourse())
                .orElseThrow(() -> new CourseNotFoundException(noteDto.getCourse()));
        Note note = new Note(noteDto.getNoteContent(), ZonedDateTime.now(),
                user, course);
        this.noteRepository.save(note);
        return Optional.of(note);
    }

    @Override
    public Optional<Note> edit(Long id, NoteDto noteDto) {
        Note note = this.noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        note.setNoteContent(noteDto.getNoteContent());
        note.setDateModified(ZonedDateTime.now());
        this.noteRepository.save(note);
        return Optional.of(note);
    }

    @Override
    public void delete(Long id) {
        Note note = this.noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        this.noteRepository.delete(note);
        System.out.println("Note deleted!");
    }
}
