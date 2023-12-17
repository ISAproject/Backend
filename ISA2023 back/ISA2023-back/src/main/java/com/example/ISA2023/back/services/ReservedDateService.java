package com.example.ISA2023.back.services;

import com.example.ISA2023.back.dtos.TrackingOrderDto;
import com.example.ISA2023.back.models.Equipment;
import com.example.ISA2023.back.models.ReservedDate;
import com.example.ISA2023.back.models.irepositories.IEquipmentRepository;
import com.example.ISA2023.back.models.irepositories.IReservedDateRepository;
import com.example.ISA2023.back.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservedDateService {
    private  final IReservedDateRepository reservedDateRepository;
    private final IEquipmentRepository equipmentRepository;
    private final IUserRepository userRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ReservedDateService(IReservedDateRepository reservedDateRepository) {
        this.reservedDateRepository = reservedDateRepository;
    }

    public List<ReservedDate> getAll() { return reservedDateRepository.findAll();}
    public ReservedDate create(ReservedDate reservedDate){
        return reservedDateRepository.save(reservedDate);
    }

    public List<Equipment> findEquipmentByReservationDateId(Long id){
        List<Long> equipmentIds=reservedDateRepository.findById(id).get().getEquipments();
        return GetAllEquipments(equipmentIds);
    }

    public List<Equipment> GetAllEquipments(List<Long> equipmentsId){
        List<Equipment> equipments=new ArrayList<>();
        for (Long id:equipmentsId ) {
            equipments.add(equipmentRepository.findById(id).get());
        }
        return equipments;
    }
    public void sendConfirmationEmail(String email,ReservedDate order){
        String medium="http://localhost:3000/qrcode-equipment/"+order.getId();
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

    public List<TrackingOrderDto> getTrackingsByEquipmentId(Long id){

    }
}
