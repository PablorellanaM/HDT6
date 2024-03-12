package com.uvg.algoritmos;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de MAP que desea usar:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int mapChoice = Integer.parseInt(scanner.nextLine());
        String mapType;
        switch (mapChoice) {
            case 1:
                mapType = "HashMap";
                break;
            case 2:
                mapType = "TreeMap";
                break;
            case 3:
                mapType = "LinkedHashMap";
                break;
            default:
                System.out.println("Opción no válida. Saliendo del programa.");
                scanner.close();
                return;
        }

        MapFactory<String, String> mapFactory = new MapFactory<>();
        Map<String, String> cardMap = mapFactory.getMap(mapType);

        // Cargar las cartas en el cardMap desde el archivo
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Main.class.getResourceAsStream("/cards_desc.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    cardMap.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Error al leer el archivo de cartas.");
            e.printStackTrace();
            scanner.close();
            return;
        }

        CardManager cardManager = new CardManager(cardMap);
        boolean running = true;
        while (running) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar una carta a la colección del usuario");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar la colección del usuario");
            System.out.println("4. Mostrar la colección del usuario ordenada por tipo");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.print("Ingrese el nombre de la carta que desea agregar: ");
                    String cardName = scanner.nextLine();
                    if (cardManager.addCardToUserCollection(cardName)) {
                        System.out.println("Carta agregada con éxito.");
                    } else {
                        System.out.println("La carta no se pudo agregar (puede que no exista).");
                    }
                    break;
                case "2":
                    System.out.print("Ingrese el nombre de la carta cuyo tipo desea conocer: ");
                    cardName = scanner.nextLine();
                    System.out.println("Tipo de carta: " + cardManager.getCardType(cardName));
                    break;
                case "3":
                    System.out.println("Colección del usuario:");
                    System.out.println(cardManager.showUserCollection());
                    break;
                case "4":
                    System.out.println("Colección del usuario ordenada por tipo:");
                    System.out.println(cardManager.showUserCollectionByType());
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Gracias por usar el programa.");
    }
}
