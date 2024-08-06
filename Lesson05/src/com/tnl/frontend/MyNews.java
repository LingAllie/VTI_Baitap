package com.tnl.frontend;

import com.tnl.entity.News;
import com.tnl.utils.ScannerUtils;
import com.tnl.backend.INews;

import java.util.ArrayList;

public class MyNews {
    public static void main(String[] args) {
        ArrayList<INews> newsList = new ArrayList<>();
        menu(newsList);
    }

    private static void menu(ArrayList<INews> newsList) {
        while (true) {
            int opt = ScannerUtils.getOption("Option is empty, please choose one!");
            switch (opt) {
                case 1:
                    INews news = getNews();
                    int[] rates = ScannerUtils.getRates("Rate's value is empty, please enter again!");
                    news.Calculate(rates);
                    newsList.add(news);
                    break;
                case 2:
                    for (INews n : newsList) {
                        n.Display();
                    }
                    break;
                case 3:
                    for (INews n : newsList) {
                        int[] newRates = ScannerUtils.getRates("Rate's value is empty, please enter again!");
                        n.Calculate(newRates);
                        n.Display();
                    }
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static INews getNews() {
        
        String title = ScannerUtils.getInfor("News's title: ", "Title is empty, please enter again!");
        String publishDate = ScannerUtils.getInfor("News's publish date: ", "Publish date is empty, please enter again!");
        String author = ScannerUtils.getInfor("News's author: ", "Author is empty, please enter again!");
        String content = ScannerUtils.getInfor("News's content: ", "Content is empty, please enter again!");

        INews news = new News(title, publishDate, author, content);
        return news;
    }
}
