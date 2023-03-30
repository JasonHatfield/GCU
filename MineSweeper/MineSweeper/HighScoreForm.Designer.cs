namespace MineSweeper
{
    partial class HighScoreForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.highScoresListView = new System.Windows.Forms.ListView();
            this.SuspendLayout();
            // 
            // highScoresListView
            // 
            this.highScoresListView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.highScoresListView.HideSelection = false;
            this.highScoresListView.Location = new System.Drawing.Point(0, 0);
            this.highScoresListView.Name = "highScoresListView";
            this.highScoresListView.Size = new System.Drawing.Size(231, 240);
            this.highScoresListView.TabIndex = 0;
            this.highScoresListView.UseCompatibleStateImageBehavior = false;
            this.highScoresListView.View = System.Windows.Forms.View.Details;
            // 
            // HighScoreForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(231, 240);
            this.Controls.Add(this.highScoresListView);
            this.Name = "HighScoreForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "HighScoreForm";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListView highScoresListView;
    }
}