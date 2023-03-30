namespace Minesweeper
{
    partial class DifficultyForm
    {
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(DifficultyForm));
            this.EasyButton = new System.Windows.Forms.Button();
            this.MediumButton = new System.Windows.Forms.Button();
            this.HardButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // EasyButton
            // 
            this.EasyButton.Location = new System.Drawing.Point(38, 12);
            this.EasyButton.Name = "EasyButton";
            this.EasyButton.Size = new System.Drawing.Size(75, 23);
            this.EasyButton.TabIndex = 0;
            this.EasyButton.Text = "Easy";
            this.EasyButton.UseVisualStyleBackColor = true;
            this.EasyButton.Click += new System.EventHandler(this.EasyButton_Click);
            // 
            // MediumButton
            // 
            this.MediumButton.Location = new System.Drawing.Point(38, 42);
            this.MediumButton.Name = "MediumButton";
            this.MediumButton.Size = new System.Drawing.Size(75, 23);
            this.MediumButton.TabIndex = 1;
            this.MediumButton.Text = "Medium";
            this.MediumButton.UseVisualStyleBackColor = true;
            this.MediumButton.Click += new System.EventHandler(this.MediumButton_Click);
            // 
            // HardButton
            // 
            this.HardButton.Location = new System.Drawing.Point(38, 72);
            this.HardButton.Name = "HardButton";
            this.HardButton.Size = new System.Drawing.Size(75, 23);
            this.HardButton.TabIndex = 2;
            this.HardButton.Text = "Hard";
            this.HardButton.UseVisualStyleBackColor = true;
            this.HardButton.Click += new System.EventHandler(this.HardButton_Click);
            // 
            // DifficultyForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(151, 113);
            this.Controls.Add(this.HardButton);
            this.Controls.Add(this.MediumButton);
            this.Controls.Add(this.EasyButton);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "DifficultyForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Minesweeper";
            this.ResumeLayout(false);

        }

        private System.Windows.Forms.Button EasyButton;
        private System.Windows.Forms.Button MediumButton;
        private System.Windows.Forms.Button HardButton;
    }
}