package com.example.ISA2023.back.utils;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;


public class QRCodeGenerator {

    public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig con = new MatrixToImageConfig( 0xFF000002 , 0xFFFFC041 ) ;

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,con);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

    /*public static String decodeQRCode(byte[] qrCodeImage) {
        try {
            logInputData(qrCodeImage);

            BufferedImage bufferedImage = readImage(qrCodeImage);
            if (bufferedImage != null) {
                BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));
                Result result = new MultiFormatReader().decode(binaryBitmap);
                return result.getText();
            } else {
                return "Error decoding QR code: BufferedImage is null.";
            }
        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
            return "Error decoding QR code: " + e.getMessage();
        }
    }

    private static void logInputData(byte[] qrCodeImage) {
        System.out.println("Input data length: " + qrCodeImage.length);
        // Add more logging as needed, depending on your requirements
        System.out.println("Sample Bytes: " + Arrays.toString(Arrays.copyOfRange(qrCodeImage, 0, Math.min(qrCodeImage.length, 10))));

    }

    private static BufferedImage readImage(byte[] qrCodeImage) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(qrCodeImage);

        // Log the supported image formats
        //String[] formatNames = ImageIO.getReaderFormatNames();
        //System.out.println("Supported Image Formats: " + Arrays.toString(formatNames));
        //File slika=new File(bis);
        return ImageIO.read(new File("C:\\Users\\strah\\Downloads\\qr_img.png"));


    }*/



    public static String decodeQR(byte[] qrCodeBytes) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(qrCodeBytes);
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(bufferedImage);
            HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource);
            BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            Result result = multiFormatReader.decode(binaryBitmap);

            return result.getText();
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
