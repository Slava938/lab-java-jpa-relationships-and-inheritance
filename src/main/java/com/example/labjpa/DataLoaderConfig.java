package com.example.labjpa;
import com.example.labjpa.entity.association.*;
import com.example.labjpa.entity.contact.Contact;
import com.example.labjpa.entity.contact.Name;
import com.example.labjpa.entity.event.*;
import com.example.labjpa.entity.task.BillableTask;
import com.example.labjpa.entity.task.InternalTask;
import com.example.labjpa.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class DataLoaderConfig {
 @Bean CommandLineRunner loadData(ContactRepository contactRepo,
            AssociationRepository associationRepo,
            DivisionRepository divisionRepo,
            MemberRepository memberRepo,
            ConferenceRepository conferenceRepo,
            ExhibitionRepository exhibitionRepo,
            GuestRepository guestRepo,
            SpeakerRepository speakerRepo,
            TaskRepository taskRepo) {
  return args -> {
    Name n1 = new Name(); n1.setSalutation("Mr."); n1.setFirstName("John"); n1.setMiddleName("Q"); n1.setLastName("Doe");
    Contact c1 = new Contact(); c1.setCompany("Blue PR"); c1.setTitle("Manager"); c1.setName(n1); contactRepo.save(c1);

    Association assoc = new Association(); assoc.setName("Nurse Association of Spain"); associationRepo.save(assoc);
    List<Division> divisions = new ArrayList<>();
    for (int i=1;i<=7;i++){ Division d=new Division(); d.setName("Division "+i); d.setDistrict("District "+((i%3)+1)); d.setAssociation(assoc); divisionRepo.save(d);
      Member m=new Member(); m.setName("Member "+i); m.setStatus(i%2==0?MemberStatus.ACTIVE:MemberStatus.LAPSED); m.setRenewalDate(LocalDate.now().plusMonths(i)); m.setDivision(d); memberRepo.save(m);
      d.setPresident(m); divisionRepo.save(d); divisions.add(d);
    }
    assoc.setDivisions(divisions); associationRepo.save(assoc);

    Guest g1=new Guest(); g1.setName("Alice"); g1.setStatus(GuestStatus.ATTENDING);
    Guest g2=new Guest(); g2.setName("Bob"); g2.setStatus(GuestStatus.NO_RESPONSE);
    guestRepo.save(g1); guestRepo.save(g2);

    Conference conf=new Conference(); conf.setTitle("Spring Spain 2025"); conf.setDate(LocalDate.now().plusDays(10)); conf.setDuration(2); conf.setLocation("Madrid"); conf.getGuests().add(g1); conf.getGuests().add(g2); conferenceRepo.save(conf);
    Speaker sp=new Speaker(); sp.setName("Dr. Rivera"); sp.setPresentationDuration(45); sp.setConference(conf); speakerRepo.save(sp);

    Exhibition ex=new Exhibition(); ex.setTitle("Health Expo"); ex.setDate(LocalDate.now().plusDays(20)); ex.setDuration(1); ex.setLocation("Barcelona"); ex.getGuests().add(g1); exhibitionRepo.save(ex);

    BillableTask bt=new BillableTask(); bt.setTitle("Prepare PR Kit"); bt.setDueDate(LocalDate.now().plusDays(7)); bt.setCompleted(false); bt.setHourlyRate(new BigDecimal("75.00")); taskRepo.save(bt);
    InternalTask it=new InternalTask(); it.setTitle("Team Retrospective"); it.setDueDate(LocalDate.now().plusDays(3)); it.setCompleted(false); taskRepo.save(it);
  };
 }
}
