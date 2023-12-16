package com.example.ISA2023.back.services;

import com.example.ISA2023.back.dtos.ReservedDatesDto;
import com.example.ISA2023.back.models.Equipment;
import com.example.ISA2023.back.models.ReservedDate;
import com.example.ISA2023.back.models.irepositories.IEquipmentRepository;
import com.example.ISA2023.back.models.irepositories.IReservedDateRepository;
import com.example.ISA2023.back.user.IUserRepository;
import com.example.ISA2023.back.user.User;
import com.example.ISA2023.back.utils.QRCodeGenerator;
import com.google.zxing.WriterException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ReservedDateService {
    private final IReservedDateRepository reservedDateRepository;
    private final IEquipmentRepository equipmentRepository;
    private final IUserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ReservedDateService(IReservedDateRepository reservedDateRepository,IEquipmentRepository equipmentRepository, IUserRepository userRepository) {
        this.reservedDateRepository = reservedDateRepository;
        this.equipmentRepository=equipmentRepository;
        this.userRepository=userRepository;
    }

    public ReservedDate create(ReservedDate reservedDate){
        return reservedDateRepository.save(reservedDate);
    }

    public List<Equipment> GetAllEquipments(List<Long> equipmentsId){
        List<Equipment> equipments=new ArrayList<>();
        for (Long id:equipmentsId ) {
            equipments.add(equipmentRepository.findById(id).get());
        }
        return equipments;
    }
    public void sendConfirmationEmail(String email,ReservedDate order){
        String medium="https://rahul26021999.medium.com/";
        byte[] image = new byte[0];
        try {
            image = QRCodeGenerator.getQRCodeImage(medium,250,250);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        //String qrcode = Base64.getEncoder().encodeToString(image);
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setSubject("Confirmation");


            StringBuilder body= new StringBuilder("Dear user,\nwe are sending you your order:\n");
            List<Equipment> equipmentList=GetAllEquipments(order.getEquipments());
            int i=1;
            for (Equipment eqipment:equipmentList) {
                body.append("\n").append(i).append(".Name: ").append(eqipment.getName()).append("\nDescription: ").append(eqipment.getDescription()).append("\nType: ").append(eqipment.getType()).append("\n");
                i++;
            }
            body.append("\n\nYour confirmation is in attached file.");
            helper.setText(body.toString());


            ByteArrayResource imageResource = new ByteArrayResource(image);
            helper.addAttachment("image.png", imageResource);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    public ReservedDate FindById(Long id){
        return reservedDateRepository.findById(id).get();
    }

    public List<ReservedDatesDto>GetByCompany(long companyId)
    {
        List<ReservedDatesDto>allDates= new ArrayList<>();
        var reservedDates=reservedDateRepository.GetByCompany(companyId);
        for ( var r :reservedDates) {
            ReservedDatesDto rd=new ReservedDatesDto();
            rd.setId(r.getId());
            rd.setDateTimeInMS(r.getDateTimeInMS());
            rd.setDuration(r.getDuration());
            rd.setUserName(userRepository.getUserById(r.getUserId()).getFirst_name());
            rd.setUserSurname(userRepository.getUserById(r.getUserId()).getLast_name());
            List<String> equipments=new ArrayList<>();
            for (var e:r.getEquipments()) {
                Equipment eq=equipmentRepository.findById(e).get();
                equipments.add(eq.getName());
            }
            rd.setEquipments(equipments);
            allDates.add(rd);
        }
        return allDates;
    }
}
