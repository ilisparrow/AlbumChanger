package com.mpatric.mp3agic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class mainCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File curDir = new File(".");
		final int NumberOfFiles = nbrefichier(curDir);
		final String[] list;
		final Mp3File mp3[] = new Mp3File[nbrefichier(curDir)];
		// mp3[] = new Mp3File("un.mp3");
		// System.out.println(mp3.getLengthInSeconds());

		list = fileLoader(curDir);
		JFrame frame = new JFrame("Album Changer");
		JPanel panel = new JPanel();
		JButton btn = new JButton("Valider");
		final JTextField txtField = new JTextField("Cocktail");

		panel.add(txtField);
		panel.add(btn);

		frame.setSize(250, 70);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		// Evenement
		/*btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {*/
				for (int i = 0; i < NumberOfFiles; i++) {

					if (list[i].charAt(list[i].length() - 1) == '3') {
						System.out.println(list[i]);
						try {
							mp3[i] = new Mp3File(list[i]);
							// System.out.println(mp3[i].getLengthInSeconds());
							ID3v1 id3v1Tag;

							if (mp3[i].hasId3v1Tag()) {
								id3v1Tag = mp3[i].getId3v1Tag();
							} else {
								id3v1Tag = new ID3v1Tag();
								mp3[i].setId3v1Tag(id3v1Tag);
							}

							id3v1Tag.setAlbum(txtField.getText());
							mp3[i].setId3v1Tag(id3v1Tag);
							try {
								mp3[i].save("_" + list[i]);
							} catch (NotSupportedException e1) {
								e1.printStackTrace();
							}

						} catch (UnsupportedTagException | InvalidDataException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}
			}
		//});

	//}

	private static String[] fileLoader(File _curDir) {// Returns a string of all
														// files in the main
														// repesitory
		File[] files = _curDir.listFiles();
		String[] listeNomFichiers = new String[files.length];
		int i = 0;

		for (File f : files) {
			if (f.isDirectory()) {
				/* System.out.println(f.getName()); */} else if (f.isFile()) {
				// System.out.println(f.getName());

				listeNomFichiers[i] = f.getName();

				i++;
			}

		}
		return listeNomFichiers;

	}

	private static int nbrefichier(File _curDir) {// Returns a string of number
													// of files in the main
													// repesitory
		File[] files = _curDir.listFiles();
		return files.length;

	}
}